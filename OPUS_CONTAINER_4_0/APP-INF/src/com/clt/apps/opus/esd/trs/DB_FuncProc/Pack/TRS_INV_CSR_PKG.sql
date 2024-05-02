CREATE OR REPLACE package TRS_INV_CSR_PKG 
AUTHID CURRENT_USER
IS
 /*  사용하지 않고 있음.. NOT USED!! */
 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAY 11, 2007
 # -- Table   : *.*
 # -- Purpose : FIND BOOKING REVENUE VVD
 #####################################################################*/
  FUNCTION GET_BKG_REV_VVD_FNC(
           in_bkg_no            IN       VARCHAR2
  )
  RETURN VARCHAR2;

end TRS_INV_CSR_PKG;
/

-- DDL Script for PACKAGE BODY TRS_INV_CSR_PKG. Orange for ORACLE.
-- Generated on 2009/07/03 13:17:16 by ENISADM@HJSENIS1

CREATE OR REPLACE PACKAGE BODY TRS_INV_CSR_PKG IS

 /*###################################################################
 # -- Author  : JEONG SANG-KI
 # -- Created : MAY 11, 2007
 # -- Table   : *.*
 # -- Purpose : FIND BOOKING REVENUE VVD
 #####################################################################*/
  FUNCTION GET_BKG_REV_VVD_FNC(
           in_bkg_no            IN       VARCHAR2
  )
  RETURN VARCHAR2
  IS
  
  ------------------------------[ ������             ]-----------------------
  
      v_bkg_count        number(2)                           ;
      v_route_cout       number(2)                        ;
      v_route_count      number(1)                        ;
      v_rank             number(1)                        ;
      v_route_no         varchar(12)                      ;
      v_vsl_cd               coa_bkg_info.vsl_cd%TYPE;
      v_skd_voy_no           coa_bkg_info.skd_voy_no%TYPE;
      v_rev_dir_cd          coa_bkg_info.rev_dir_cd%TYPE;
      v_bkg_por_cd           coa_bkg_info.bkg_por_cd%TYPE;
      v_bkg_pol_cd           coa_bkg_info.bkg_pol_cd%TYPE;
      v_bkg_pod_cd           coa_bkg_info.bkg_pod_cd%TYPE;
      v_bkg_del_cd           coa_bkg_info.bkg_del_cd%TYPE;
      v_bkg_rcv_term_cd      coa_bkg_info.bkg_rcv_term_cd%TYPE;
      v_bkg_de_term_cd       coa_bkg_info.bkg_de_term_cd%TYPE;
      v_n1st_pol_cd          coa_bkg_info.n1st_pol_cd%TYPE;
      v_n2nd_pol_cd          coa_bkg_info.n2nd_pol_cd%TYPE;
      v_n3rd_pol_cd          coa_bkg_info.n3rd_pol_cd%TYPE;
      v_n4th_pol_cd          coa_bkg_info.n4th_pol_cd%TYPE;
      v_n1st_pod_cd          coa_bkg_info.n1st_pod_cd%TYPE;
      v_n2nd_pod_cd          coa_bkg_info.n2nd_pod_cd%TYPE;
      v_n3rd_pod_cd          coa_bkg_info.n3rd_pod_cd%TYPE;
      v_n4th_pod_cd          coa_bkg_info.n4th_pod_cd%TYPE;
      v_n1st_rlane_cd        coa_bkg_info.n1st_rlane_cd%TYPE;
      v_n2nd_rlane_cd        coa_bkg_info.n2nd_rlane_cd%TYPE;
      v_n3rd_rlane_cd        coa_bkg_info.n3rd_rlane_cd%TYPE;
      v_n4th_rlane_cd        coa_bkg_info.n4th_rlane_cd%TYPE;
      v_n1st_ioc_cd      varchar(2)                       ;
      v_n2nd_ioc_cd      varchar(2)                       ;
      v_n3rd_ioc_cd      varchar(2)                       ;
      v_n4th_ioc_cd      varchar(2)                       ; 
      v_pol1_conti       varchar(1)                       ;
      v_pol2_conti       varchar(1)                       ;
      v_pol3_conti       varchar(1)                       ;
      v_pol4_conti       varchar(1)                       ;
      v_pod1_conti       varchar(1)                       ;
      v_pod2_conti       varchar(1)                       ;
      v_pod3_conti       varchar(1)                       ;
      v_pod4_conti       varchar(1)                       ;
      v_trade1_cd        varchar(3)                       ;
      v_trade2_cd        varchar(3)                       ;
      v_trade3_cd        varchar(3)                       ;
      v_trade4_cd        varchar(3)                       ;
      v_svc_mode_cd      varchar(5);
      v_n1st_vvd_cd      varchar(10)                       ;
      v_n2nd_vvd_cd      varchar(10)                       ;
      v_n3rd_vvd_cd      varchar(10)                       ;
      v_n4th_vvd_cd      varchar(10)                       ; 
      v_n1st_conti      varchar(2)                       ;
      v_n2nd_conti      varchar(2)                       ;
      v_n3rd_conti      varchar(2)                       ;
      v_n4th_conti      varchar(2)                       ; 
      v_row_cnt         number;
      
      v_rev_vvd_cd      varchar(10);
  -- ===== BEGIN, EXCEPTION & END ======================================
     v_return   NUMBER;
  BEGIN
          /** �ʱⰪ ��d **/
          v_bkg_count := 0 ;
          v_route_count :=0 ;
     -------------------------------[ �׷ο켱��'/Reveneu conversion  �۾� ó��         ]----------------------- 
   
     SELECT NVL(SAQ_GET_RLANE_FNC(first_lane_cd,first_pol_cd,first_pod_cd), 'RBCCO'),
            decode(second_lane_cd,'',null,SAQ_GET_RLANE_FNC(second_lane_cd,second_pol_cd,second_pod_cd)),
            decode(third_lane_cd,'',null,SAQ_GET_RLANE_FNC(third_lane_cd,third_pol_cd,third_pod_cd)),
            decode(fourth_lane_cd,'',null,SAQ_GET_RLANE_FNC(fourth_lane_cd,fourth_pol_cd,fourth_pod_cd)),
                                decode(X_1_POL_CONTI,X_1_POD_CONTI,'I','O'),
                                decode(X_2_POL_CONTI,X_2_POD_CONTI,'I','O'),
                                decode(X_3_POL_CONTI,X_3_POD_CONTI,'I','O'),
                                decode(X_4_POL_CONTI,X_4_POD_CONTI,'I','O'),
                                rcv_term_cd,dlv_term_cd,bkg_por_cd,bkg_pol_cd,bkg_pod_cd,bkg_del_cd,
                                
             SAQ_GET_TRD_FNC(SAQ_GET_RLANE_FNC(first_lane_cd,first_pol_cd,first_pod_cd),first_pol_cd,first_pod_cd),
            decode(second_lane_cd,'',null,SAQ_GET_TRD_FNC(SAQ_GET_RLANE_FNC(second_lane_cd,second_pol_cd,second_pod_cd),second_pol_cd,second_pod_cd)),
            decode(third_lane_cd,'',null,SAQ_GET_TRD_FNC(SAQ_GET_RLANE_FNC(third_lane_cd,third_pol_cd,third_pod_cd),third_pol_cd,third_pod_cd)),
            decode(fourth_lane_cd,'',null,SAQ_GET_TRD_FNC(SAQ_GET_RLANE_FNC(fourth_lane_cd,fourth_pol_cd,fourth_pod_cd),fourth_pol_cd,fourth_pod_cd)),                             
            
            x_first_vvd||nvl(coa_rev_dir_conv_fnc(first_lane_cd,first_pol_cd,substr(x_first_vvd,9,1)),substr(x_first_vvd,9,1)),
            x_second_vvd||nvl(decode(second_lane_cd,'',null,coa_rev_dir_conv_fnc(second_lane_cd,second_pol_cd,substr(x_second_vvd,9,1))),substr(x_second_vvd,9,1)),
            x_third_vvd||nvl(decode(third_lane_cd,'',null,coa_rev_dir_conv_fnc(third_lane_cd,third_pol_cd,substr(x_third_vvd,9,1))),substr(x_third_vvd,9,1)),
            x_fourth_vvd||nvl(decode(fourth_lane_cd,'',null,coa_rev_dir_conv_fnc(fourth_lane_cd,fourth_pol_cd,substr(x_fourth_vvd,9,1))),substr(x_fourth_vvd,9,1)),
            decode(X_1_POL_CONTI,X_1_POD_CONTI,'I'||X_1_POD_CONTI,'OO'),
            decode(X_2_POL_CONTI,X_2_POD_CONTI,'I'||X_2_POD_CONTI,'OO'),
            decode(X_3_POL_CONTI,X_3_POD_CONTI,'I'||X_3_POD_CONTI,'OO'),
            decode(X_4_POL_CONTI,X_4_POD_CONTI,'I'||X_4_POD_CONTI,'OO')
       INTO   v_n1st_rlane_cd    ,v_n2nd_rlane_cd    ,v_n3rd_rlane_cd    ,v_n4th_rlane_cd    ,                       
              v_n1st_ioc_cd      ,v_n2nd_ioc_cd      ,v_n3rd_ioc_cd      ,v_n4th_ioc_cd        ,
              v_bkg_rcv_term_cd  ,v_bkg_de_term_cd   ,
              v_bkg_por_cd       ,v_bkg_pol_cd       ,v_bkg_pod_cd       ,v_bkg_del_cd       , 
              v_trade1_cd        ,v_trade2_cd        ,v_trade3_cd        ,v_trade4_cd        ,  
              v_n1st_vvd_cd      ,v_n2nd_vvd_cd      ,v_n3rd_vvd_cd      ,v_n4th_vvd_cd       ,
              v_n1st_conti ,v_n2nd_conti,v_n3rd_conti,v_n4th_conti       
      FROM AGT_BOOKING_V
      WHERE key_bkg_no = in_bkg_no;
                        
      v_rank :=coa_rank_info_fnc(v_n1st_rlane_cd,v_n2nd_rlane_cd,v_n3rd_rlane_cd,v_n4th_rlane_cd,v_n1st_conti ,v_n2nd_conti,v_n3rd_conti,v_n4th_conti);  
      
       SELECT DECODE(DECODE(v_rank, 1, v_n1st_rlane_cd, 2, v_n2nd_rlane_cd,3, v_n3rd_rlane_cd, v_n4th_rlane_cd), 'RBCCO',
                NVL('CFDR'||TO_CHAR(sysdate, 'YYMM')||'EE',
                DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),
                     'RBC',
                     DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', TO_CHAR(SYSDATE, 'YYMM'), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd), 
                     DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))), DECODE(SUBSTR(DECODE(v_rank,1,v_n1st_rlane_cd,2,v_n2nd_rlane_cd,3,v_n3rd_rlane_cd,v_n4th_rlane_cd),1,3),
                     'RBC',
                     DECODE(SUBSTR(v_n1st_vvd_cd, 0, 2), 'FD', 'CFDR'||DECODE(SUBSTR(v_n1st_vvd_cd, 3, 4), '9999', TO_CHAR(SYSDATE, 'YYMM'), SUBSTR(v_n1st_vvd_cd, 3, 4))||'EE', v_n1st_vvd_cd), 
                     DECODE(v_rank,1,v_n1st_vvd_cd,2,v_n2nd_vvd_cd,3,v_n3rd_vvd_cd,v_n4th_vvd_cd))) REV_VVD_CD
       INTO v_rev_vvd_cd
       FROM  agt_booking_v
       WHERE  key_bkg_no = in_bkg_no;
       
     
      RETURN v_rev_vvd_cd;   
           
      EXCEPTION
         WHEN OTHERS THEN
           RETURN NULL;
        
  END;



end TRS_INV_CSR_PKG;
/
