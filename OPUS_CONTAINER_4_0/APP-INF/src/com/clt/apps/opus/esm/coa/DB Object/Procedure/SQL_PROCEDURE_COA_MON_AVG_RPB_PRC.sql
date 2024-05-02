CREATE OR REPLACE PROCEDURE COA_MON_AVG_RPB_PRC
( 
    in_tgt_yrmon  IN VARCHAR2  -- Target Year Month 
   ,in_yrmon      IN VARCHAR2  -- Source YYYYMM 
   ,in_week       IN VARCHAR2  -- Source Start Week 
   ,in_week_dur   IN NUMBER    -- duration 
   ,in_user_id    IN VARCHAR2  -- User id    
         
) 
Authid current_user
IS 
/****************************************************************************** 
   Name         :   COA_MON_AVG_RPB_PRC 
   Purpose      :   월별 평균 RPB 관리 
   Source       :   COA_RGST_BKG 
   Target       :   COA_MON_ROUT_RPB 
   Revision History
      1. 2014.07.01 Inital created
      2. 2015.06.02 SMY Adding user id 
   
    
   BEGIN 
       COA_MON_AVG_RPB_PRC( 
                          '100909' --Target Year Month 
                         ,'200909' --Source YYYYMM 
                         ,'31' --Source Start Week 
                         ,'5' --duration 
                          ); 
       COMMIT; 
   END; 
    
******************************************************************************/ 
 
------------------------------[ 변수선언부             ]----------------------- 
 
    /** 작업로그 관련 변수선언 **/   
    v_mig_pgm_nm       varchar2(100 )   := 'COA_MON_AVG_RPB_PRC'     ;  
    v_mig_sub_sys_cd   varchar2(3   )   := 'COA'                     ; 
    v_mig_pic_nm       varchar2(20  )   := '오명석'                  ; 
    v_tgt_tbl_nm       varchar2(100 )   := 'COA_MON_ROUT_RPB'        ;  
    v_src_tbl_nm       varchar2(100 )   := 'COA_BKG_INFO'            ; 
    v_mig_err_msg      varchar2(1000)                                ; 
    v_mig_knt          number(18)       := 0                         ;         
    v_mig_st_dt        date                                          ; 
     
    v_yrmon            varchar(6)                                    ; 
    v_fm_yr            varchar(4)                                    ; 
    v_fm_wk            varchar(2)                                    ; 
    v_to_yr            varchar(4)                                    ; 
    v_to_wk            varchar(2)                                    ; 
    v_week_dur         number(2)        := 12                        ;  -- 12주간의 RPB 
 
-------------------------------[ 업무로직 구현부       ]-----------------------  
BEGIN 
        /** 시작일시 설정 **/ 
        v_mig_st_dt := sysdate ; 
         
        --enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_AVG_RPB_PRC] : Started (Input Parameter - ' || in_yrmon || '), ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')); 
         
        -- 입력된 주간의 RPB                         
        IF in_week_dur > 0 THEN  
            v_week_dur := in_week_dur; 
        END IF;                                     
         
        IF in_yrmon = '0' AND in_week = '0' THEN    
         
            -- 현재 주 찾아 오기         
            SELECT  COST_YR 
                   ,COST_WK 
            INTO    v_to_yr 
                   ,v_to_wk 
            FROM   COA_WK_PRD 
            WHERE  TO_CHAR(v_mig_st_dt, 'YYYYMMDD') BETWEEN SLS_FM_DT  
                                                    AND     SLS_TO_DT;   
                                                     
            v_yrmon := TO_CHAR(v_mig_st_dt, 'YYYYMM');                                                                                                     
                                                     
        ELSE 
         
            -- Year/Week Validation 
            SELECT  COST_YR 
                   ,COST_WK 
            INTO    v_to_yr 
                   ,v_to_wk 
            FROM   COA_WK_PRD 
            WHERE  COST_YR = SUBSTR(in_yrmon, 1, 4) 
            AND    COST_WK = in_week   ; 
             
            v_yrmon := in_yrmon; 
             
        END IF;          
                                 
        -- 12주 전 찾아오기 
        SELECT  COST_YR 
               ,COST_WK  
        INTO    v_fm_yr 
               ,v_fm_wk 
        FROM ( 
                SELECT  ROWNUM ROW_NUM 
                       ,COST_YR 
                       ,COST_WK  
                FROM ( 
                        SELECT  COST_YR 
                               ,COST_WK 
                        FROM   COA_WK_PRD 
                        WHERE  COST_YR||COST_WK < v_to_yr||v_to_wk 
                        ORDER BY COST_YR||COST_WK DESC 
                     ) 
              ) 
        WHERE ROW_NUM = v_week_dur; 
         
--        DBMS_OUTPUT.put_line (   '[COA_MON_AVG_RPB_PRC1] : Duration (' 
--                                 || v_fm_yr||v_fm_wk 
--                                 || ', ' 
--                                 || v_to_yr||v_to_wk 
--                                 || '), ' 
--                                 || TO_CHAR (SYSDATE, 'yyyy/mm/dd hh24:mi:ss') 
--                                );                                                                
         
        /** 이미 만들어진 데이터가 있을 경우 삭제 **/ 
        DELETE COA_MON_ROUT_RPB 
        WHERE  RPB_YRMON = in_tgt_yrmon; 
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_ROUT_RPB] : ' || SQL%ROWCOUNT || ' Records Deleted, ' || in_tgt_yrmon ); 
 
        INSERT INTO COA_MON_ROUT_RPB  
        (RPB_YRMON 
        ,RLANE_CD 
        ,IOC_CD 
        ,BKG_POR_CD 
        ,BKG_DEL_CD 
        ,CNTR_TPSZ_CD 
        ,BKG_AVG_RPB_REV 
        ,BKG_OFT_AVG_RPB_REV 
        ,BKG_MISC_AVG_RPB_REV 
        ,SCR_CHG_AVG_RPB_REV 
        ,CRE_USR_ID 
        ,CRE_DT
        ,UPD_USR_ID
        ,UPD_DT)
        (select  in_tgt_yrmon 
                ,b.RLANE_CD 
                ,b.IOC_CD 
                ,BKG_POR_CD 
                ,BKG_DEL_CD 
                ,c.CNTR_TPSZ_CD 
                ,sum(c.BKG_REV      )/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.BKG_OFT_REV  )/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.BKG_MISC_REV2)/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.SCR_CHG_REV  )/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,NVL(in_user_id,'COA_USER') --'System' 2015.06.02 Update
                ,sysdate 
                ,NVL(in_user_id,'COA_USER') --'RPB_Cost' 2015.06.02 Update
                ,sysdate
        from    coa_mon_vvd a, coa_rgst_bkg b, coa_bkg_rev_dtl c 
        where   a.TRD_CD                = b.TRD_CD 
        and     a.RLANE_CD              = b.RLANE_CD 
        and     a.IOC_CD                = b.IOC_CD 
        and     a.VSL_CD                = b.VSL_CD 
        and     a.SKD_VOY_NO            = b.SKD_VOY_NO 
        and     a.DIR_CD                = b.DIR_CD 
        and     a.delt_flg = 'N' 
        and     b.bkg_sts_cd            in ('F','S') 
        and     b.bkg_cgo_tp_cd         <> 'P' 
        and     a.COST_YRMON            like v_fm_yr || '%' 
        and     a.COST_WK               BETWEEN v_fm_wk AND v_to_wk  
        and     b.bkg_no                = c.bkg_no 
        group by     b.RLANE_CD 
                    ,b.IOC_CD 
                    ,BKG_POR_CD 
                    ,BKG_DEL_CD 
                    ,c.CNTR_TPSZ_CD); 
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_ROUT_RPB] : ' || SQL%ROWCOUNT || ' Records Inserted, ' || in_tgt_yrmon || ' : '||v_fm_yr||v_fm_wk ||' : '||v_to_yr||v_to_wk ); 
    
        /** 이미 만들어진 데이터가 있을 경우 삭제 **/ 
        DELETE COA_MON_SCC_RPB 
        WHERE  RPB_YRMON = in_tgt_yrmon; 
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_SCC_RPB] : ' || SQL%ROWCOUNT || ' Records Deleted, ' || in_tgt_yrmon); 
         
        INSERT INTO COA_MON_SCC_RPB 
        (RPB_YRMON 
        ,BKG_POR_SCC_CD 
        ,BKG_DEL_SCC_CD 
        ,CNTR_TPSZ_CD 
        ,BKG_AVG_RPB_REV 
        ,BKG_OFT_AVG_RPB_REV 
        ,BKG_MISC_AVG_RPB_REV 
        ,SCR_CHG_AVG_RPB_REV 
        ,CRE_USR_ID 
        ,CRE_DT
        ,UPD_USR_ID
        ,UPD_DT)  
        (select  in_tgt_yrmon 
                ,nvl(d.scc_cd,'XXXXX') 
                ,nvl(e.scc_cd,'XXXXX') 
                ,c.CNTR_TPSZ_CD 
                ,sum(c.BKG_REV)/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.BKG_OFT_REV)/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.BKG_MISC_REV2)/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,sum(c.SCR_CHG_REV)/DECODE(sum(c.BKG_QTY),0,1,sum(c.BKG_QTY)) 
                ,NVL(in_user_id,'COA_USER') --'System'  2015.06.02 Update
                ,sysdate 
                ,NVL(in_user_id,'COA_USER') --'RPB_Cost' 2015.06.02 Update
                ,sysdate
        from    coa_mon_vvd a,coa_rgst_bkg b,coa_bkg_rev_dtl c,mdm_location d,mdm_location e 
        where   a.TRD_CD                = b.TRD_CD 
        and     a.RLANE_CD              = b.RLANE_CD 
        and     a.IOC_CD                = b.IOC_CD 
        and     a.VSL_CD                = b.VSL_CD 
        and     a.SKD_VOY_NO            = b.SKD_VOY_NO 
        and     a.DIR_CD                = b.DIR_CD 
        and     a.delt_flg = 'N' 
        and     b.bkg_sts_cd            in ('F','S') 
        and     b.bkg_cgo_tp_cd         <> 'P' 
        and     a.COST_YRMON            like v_fm_yr || '%' 
        and     a.COST_WK               BETWEEN v_fm_wk AND v_to_wk  
        and     b.bkg_no        = c.bkg_no 
        and     b.bkg_por_cd    = d.loc_cd 
        and     b.bkg_del_cd    = e.loc_cd 
        group by     d.scc_cd 
                    ,e.scc_cd 
                    ,c.CNTR_TPSZ_CD);  
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_SCC_RPB] : ' || SQL%ROWCOUNT || ' Records Inserted, ' || in_tgt_yrmon || ' : '||v_fm_yr||v_fm_wk ||' : '||v_to_yr||v_to_wk ); 
    
 
        /** 이미 만들어진 데이터가 있을 경우 삭제 **/ 
        DELETE COA_MON_LANE_RPB 
        WHERE  RPB_YRMON = in_tgt_yrmon; 
         
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_LANE_RPB] : ' || SQL%ROWCOUNT || ' Records Deleted, ' || in_tgt_yrmon ); 
         
        INSERT INTO COA_MON_LANE_RPB 
        (RPB_YRMON 
        ,RLANE_CD 
        ,IOC_CD 
        ,DIR_CD 
        ,NET_20FT_AVG_REV 
        ,OFT_20FT_AVG_REV 
        ,MISC_20FT_AVG_REV 
        ,SCR_20FT_AVG_REV 
        ,NET_40FT_AVG_REV 
        ,OFT_40FT_AVG_REV 
        ,MISC_40FT_AVG_REV 
        ,SCR_40FT_AVG_REV 
        ,CRE_USR_ID 
        ,CRE_DT
        ,UPD_USR_ID
        ,UPD_DT)  
        (select  a 
                ,b 
                ,c 
                ,d 
                ,amt1/decode(rpb1,0,1,rpb1),amt2/decode(rpb2,0,1,rpb2) 
                ,amt3/decode(rpb3,0,1,rpb3),amt4/decode(rpb4,0,1,rpb4) 
                ,amt5/decode(rpb5,0,1,rpb5),amt6/decode(rpb6,0,1,rpb6) 
                ,amt7/decode(rpb7,0,1,rpb7),amt8/decode(rpb8,0,1,rpb8) 
                ,NVL(in_user_id,'COA_USER') --'System' 2015.06.02 Update
                ,Sysdate 
                ,NVL(in_user_id,'COA_USER') --'RPB_Cost' 2015.06.02 Update
                ,Sysdate
        from (  
                select   in_tgt_yrmon                                               a 
                        ,a.RLANE_CD                                                 b 
                        ,a.ioc_cd                                                   c 
                        ,a.DIR_CD                                                   d 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_REV,0))       AMT1 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB1 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_OFT_REV,0))   AMT2 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB2 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_MISC_REV2,0))  AMT3 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB3 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',SCR_CHG_REV,0))   AMT4 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB4 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_REV))       AMT5 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB5 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_OFT_REV))   AMT6 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB6 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_MISC_REV2))  AMT7 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB7 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,SCR_CHG_REV))   AMT8 
                        ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB8 
                        ,'System' 
                        ,sysdate 
                from coa_mon_vvd a,coa_rgst_bkg b,coa_bkg_rev_dtl c 
                where a.TRD_CD              = b.TRD_CD 
                and a.RLANE_CD              = b.RLANE_CD 
                and a.IOC_CD                = b.IOC_CD 
                and a.VSL_CD                = b.VSL_CD 
                and a.SKD_VOY_NO            = b.SKD_VOY_NO 
                and a.DIR_CD                = b.DIR_CD 
                and a.delt_flg = 'N' 
                and b.bkg_sts_cd            in ('F','S') 
                and b.bkg_cgo_tp_cd         <> 'P' 
                and a.COST_YRMON            like v_fm_yr || '%' 
                and a.COST_WK               BETWEEN v_fm_wk AND v_to_wk  
                and b.bkg_no                = c.bkg_no 
                group by     a.RLANE_CD 
                            ,a.ioc_CD 
                            ,a.DIR_CD) 
        ); 
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_LANE_RPB] : ' || SQL%ROWCOUNT || ' Records Inserted, ' || in_tgt_yrmon || ' : '||v_fm_yr||v_fm_wk ||' : '||v_to_yr||v_to_wk ); 
    
 
        /** 이미 만들어진 데이터가 있을 경우 삭제 **/ 
        DELETE COA_MON_TRD_RPB 
        WHERE  RPB_YRMON = in_tgt_yrmon;          
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_AVG_RPB_PRC] : ' || SQL%ROWCOUNT || ' Records Deleted, ' || in_tgt_yrmon ); 
        
        INSERT INTO COA_MON_TRD_RPB 
        (RPB_YRMON 
        ,DIR_CD 
        ,TRD_CD 
        ,NET_20FT_AVG_REV 
        ,OFT_20FT_AVG_REV 
        ,MISC_20FT_AVG_REV 
        ,SCR_20FT_AVG_REV 
        ,NET_40FT_AVG_REV 
        ,OFT_40FT_AVG_REV 
        ,MISC_40FT_AVG_REV 
        ,SCR_40FT_AVG_REV 
        ,CRE_USR_ID 
        ,CRE_DT
        ,UPD_USR_ID
        ,UPD_DT) 
        (   select   a 
                    ,b 
                    ,c 
                    ,amt1/decode(rpb1,0,1,rpb1),amt2/decode(rpb2,0,1,rpb2) 
                    ,amt3/decode(rpb3,0,1,rpb3),amt4/decode(rpb4,0,1,rpb4) 
                    ,amt5/decode(rpb5,0,1,rpb5),amt6/decode(rpb6,0,1,rpb6) 
                    ,amt7/decode(rpb7,0,1,rpb7),amt8/decode(rpb8,0,1,rpb8)  
                    ,NVL(in_user_id,'COA_USER') --'System'  2015.06.02 Update
                    ,Sysdate
                    ,NVL(in_user_id,'COA_USER') --'RPB_Cost'  2015.06.02 Update
                    ,Sysdate  
            from ( 
                    select   in_tgt_yrmon                                               a 
                            ,a.DIR_CD                                                   b 
                            ,a.TRD_CD                                                   c 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_REV,0))       amt1 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB1 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_OFT_REV,0))   amt2 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB2 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',BKG_MISC_REV2,0))  amt3 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB3 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',SCR_CHG_REV,0))   amt4 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',c.BKG_QTY,0))     RPB4 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_REV))       amt5 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB5 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_OFT_REV))   amt6 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB6 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,BKG_MISC_REV2))  amt7 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB7 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,SCR_CHG_REV))   amt8 
                            ,sum(decode(substr(c.CNTR_TPSZ_CD,-1),'2',0,c.BKG_QTY))     RPB8 
                            ,'System'  
                            ,sysdate 
                    from    coa_mon_vvd a,coa_rgst_bkg b,coa_bkg_rev_dtl c 
                    where   a.TRD_CD                = b.TRD_CD 
                    and     a.RLANE_CD              = b.RLANE_CD 
                    and     a.IOC_CD                = b.IOC_CD 
                    and     a.VSL_CD                = b.VSL_CD 
                    and     a.SKD_VOY_NO            = b.SKD_VOY_NO 
                    and     a.DIR_CD                = b.DIR_CD 
                    and     a.delt_flg = 'N' 
                    and     b.bkg_sts_cd            in ('F','S') 
                    and     b.bkg_cgo_tp_cd         <> 'P' 
                    and     a.COST_YRMON            like v_fm_yr || '%' 
                    and     a.COST_WK               BETWEEN v_fm_wk AND v_to_wk  
                    and     b.bkg_no                = c.bkg_no 
                    group by     a.DIR_CD 
                                ,a.TRD_CD) 
        );  
        enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_TRD_RPB] : ' || SQL%ROWCOUNT || ' Records Inserted, ' || in_tgt_yrmon || ' : '||v_fm_yr||v_fm_wk ||' : '||v_to_yr||v_to_wk); 
    
                     
        COMMIT;   
 
-------------------------------[ 작업로그 처리         ]-----------------------  
       --enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_AVG_RPB_PRC] : ' || v_mig_knt  || ' Records Inserted, ' || to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')); 
       --enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','End'); 
-------------------------------[ 예외처리부            ]-----------------------  
 
EXCEPTION 
 WHEN OTHERS THEN 
     ROLLBACK; 
      
     v_mig_err_msg  := SQLERRM ; 
     enis_log_prc (SYSDATE, 'COA_MON_AVG_RPB_PRC','[COA_MON_AVG_RPB_PRC] : Error -' || v_mig_err_msg || ', '||to_char(sysdate,'yyyy/mm/dd hh24:mi:ss')); 
         
END COA_MON_AVG_RPB_PRC;