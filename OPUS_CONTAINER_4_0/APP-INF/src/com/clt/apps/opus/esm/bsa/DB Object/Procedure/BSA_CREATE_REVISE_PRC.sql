CREATE OR REPLACE PROCEDURE OPUSADM."BSA_CREATE_REVISE_PRC" 
(
  p_error_code OUT VARCHAR2,
  p_error_msg  OUT VARCHAR2
)
Authid current_user
IS
/******************************************************************************
  Name         :   BSA_CREATE_REVISE_PRC
  Purpose      :   BSA CONTRACT의 FROM DATE를 운항 스케쥴에 따라 변경
  Source       :   vsk_vsl_port_skd
  Target       :   BSA_JNT_OP_BZC,BSA_SLT_CHTR_BZC
  Ver          :   1.0                       
  Date         :   2007.02.07
  System       :   Sales Managemenet > Basic Slot Allotment
  Author       :   CyberLogitec
******************************************************************************/

------------------------------- [ 커서 선언부    ] --------------------------------------
------------------------------- [ 변수 선언부    ] --------------------------------------

/** 작업로그 관련 변수선언 **/  
v_mig_pgm_nm       varchar2(100)  := 'BSA_CREATE_REVISE_PRC' ; 
v_chk_ind          varchar2(2)    := 'OK'; /* 항차의 FIRST ETD DT가 이전 */
v_err_contents     varchar2(100)  ; /* Error가 난 내용 */
/** 오류 변수 선언 **/
BSA_UPDATE_ERROR      EXCEPTION                                  ;
    
------------------------------- [ 업무로직 구현부] --------------------------------------
BEGIN
  DBMS_OUTPUT.ENABLE;
  
    /* JO 에 대해서... */
	BEGIN
	    
		MERGE INTO bsa_jnt_op_bzc x
		USING (
		      SELECT a.bsa_seq, a.rlane_cd, a.dir_cd, a.trd_cd, a.vop_cd, a.vsl_capa, a.vvd_cd, a.bsa_fm_dt, a.bsa_to_dt,
		             TO_CHAR(MIN(b.vps_etd_dt),'yyyymmdd') as fm_dt,
		             LEAD(TO_CHAR(MIN(b.vps_etd_dt)-1,'yyyymmdd')) OVER(PARTITION BY a.rlane_cd,a.dir_cd,a.trd_cd,a.vop_cd,a.vsl_capa
		                                                                               ORDER BY a.rlane_cd, a.dir_cd,trd_cd, a.vop_cd, a.vsl_capa, a.bsa_seq ) to_dt,
		             count(1) over(partition by a.RLANE_CD,a.DIR_CD,a.TRD_CD,a.VOP_CD,a.VSL_CAPA) cnt
		      FROM bsa_jnt_op_bzc a, vsk_vsl_port_skd b
		      WHERE b.vsl_cd     = substr(a.vvd_cd, 1,4)
		        AND b.skd_voy_no = substr(a.vvd_cd, 5,4)
		        AND b.skd_dir_cd = substr(a.vvd_cd, 9,1)
		        --AND NVL(b.cng_sts_cd, '*') <>'S'
		      GROUP BY a.bsa_seq,a.rlane_cd,a.dir_cd,a.trd_cd,a.vop_cd,vsl_capa,a.vvd_cd,a.bsa_fm_dt,a.bsa_to_dt
		      ORDER BY a.rlane_cd, a.dir_cd,trd_cd, a.vop_cd, a.vsl_capa,  a.bsa_seq
		      ) y
		ON (
		      x.bsa_seq  = y.bsa_seq
		  AND x.rlane_cd = y.rlane_cd
		  AND x.dir_cd   = y.dir_cd
		  AND x.trd_cd   = y.trd_cd
		  AND x.vop_cd   = y.vop_cd
		  AND x.vsl_capa = y.vsl_capa
		  )
		WHEN MATCHED THEN
		 UPDATE
		   SET x.bsa_fm_dt  = NVL(y.fm_dt, '99991231'),
		       x.bsa_to_dt  = NVL(y.to_dt, '99991231'),
		       x.upd_dt     = SYSDATE
		;
		enis_log_prc(SYSDATE, 'BSA_CREATE_REVISE_PRC', '---------------------------------------'|| TO_CHAR(sql%rowcount) , 'JO Revise');
	EXCEPTION when others then
	   v_err_contents :='Failed to Update From Date(J/O)';
	   RAISE;           
	END;
	   
	/* SC 에 대해서... */
	BEGIN
	    
		MERGE INTO bsa_slt_chtr_bzc x
		USING (
		       SELECT a.bsa_seq, a.rlane_cd, a.dir_cd, a.trd_cd, a.vsl_seq, a.vvd_cd, a.bsa_fm_dt, a.bsa_to_dt,
		              TO_CHAR(MIN(b.vps_etd_dt), 'yyyymmdd') as fm_dt,
		              LEAD(TO_CHAR(MIN(b.vps_etd_dt)-1, 'yyyymmdd')) OVER(PARTITION by a.rlane_cd, a.dir_cd, a.trd_cd
		                                ORDER BY a.bsa_seq ) to_dt,
		              COUNT(1) OVER(PARTITION BY a.rlane_cd, a.dir_cd, a.trd_cd) cnt
		       FROM bsa_slt_chtr_bzc a, vsk_vsl_port_skd b
		       WHERE b.vsl_cd     = substr(a.vvd_cd, 1,4)
		         AND b.skd_voy_no = substr(a.vvd_cd, 5,4)
		         AND b.skd_dir_cd = substr(a.vvd_cd, 9,1)
		         --AND NVL(b.cng_sts_cd, '*') <>'S'
		       GROUP BY a.bsa_seq, a.rlane_cd, a.dir_cd, a.trd_cd, a.vsl_seq, a.vvd_cd, a.bsa_fm_dt, a.bsa_to_dt
		      ) y
		ON (
		        x.bsa_seq  = y.bsa_seq
		    AND x.rlane_cd = y.rlane_cd
		    AND x.dir_cd   = y.dir_cd
		    AND x.trd_cd   = y.trd_cd
		    AND x.vsl_seq  = y.vsl_seq
		   )
		WHEN MATCHED THEN
		    UPDATE
		       SET x.bsa_fm_dt  = NVL(y.fm_dt, '99991231'),
		           x.bsa_to_dt  = NVL(y.to_dt, '99991231'),
		           x.upd_dt     = SYSDATE
		;
		enis_log_prc(SYSDATE, 'BSA_CREATE_REVISE_PRC', '---------------------------------------' || TO_CHAR(sql%rowcount) , 'SC Revise');  
	EXCEPTION when others then
	   v_err_contents :='Failed to Update From Date(S/C)';
	   RAISE;           
	END;  
  
  
    p_error_code :='00000';
    p_error_msg  :='Completed!';
COMMIT;
----------------------------- [ 예외 처리부    ] --------------------------------------
EXCEPTION
  WHEN BSA_UPDATE_ERROR THEN
    p_error_code := '00028';
    p_error_msg  := v_err_contents;
    enis_log_prc(SYSDATE, 'BSA_CREATE_REVISE_PRC', p_error_msg , 'Exception');  
  WHEN OTHERS THEN        
    p_error_code   := SQLCODE;
    p_error_msg    := SQLERRM; 
    enis_log_prc(SYSDATE, 'BSA_CREATE_REVISE_PRC', p_error_msg , 'Exception');  
    ROLLBACK; 
END BSA_CREATE_REVISE_PRC;