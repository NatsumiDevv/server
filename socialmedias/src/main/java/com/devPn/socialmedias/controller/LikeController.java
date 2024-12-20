package com.devPn.socialmedias.controller;

import com.devPn.socialmedias.model.request.LikeRequest;
import com.devPn.socialmedias.model.response.LikeResponse;
import com.devPn.socialmedias.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LikeRequest likeRequest){

        return new ResponseEntity<>(likeService.add(likeRequest), HttpStatus.OK);
    }

    @GetMapping("/getallbypost/{postId}")
    public ResponseEntity<List<LikeResponse>> getAllByPost(@PathVariable int postId){
        return new ResponseEntity<>(likeService.getAllByPost(postId), HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<LikeResponse>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(likeService.getAllByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/isliked")
    public ResponseEntity<Boolean> isLiked(@RequestParam int userId,@RequestParam int postId){
        return new ResponseEntity<>(likeService.isLiked(userId,postId),HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LikeRequest likeRequest){

        return new ResponseEntity<>(likeService.delete(likeRequest),HttpStatus.OK);
    }
}
