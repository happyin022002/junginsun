CREATE OR REPLACE FUNCTION SCE_GET_CRNT_VSL_STS_FNC ( v_vsl_cd VARCHAR2, v_skd_voy_no VARCHAR2, v_skd_dir_cd VARCHAR2 )  
  
/*******************************************************************************  
   1. Object Name      : SCE_GET_CRNT_VSL_STS  
   2. Version          : 1.0  
   3. Create Date      : 2011.01.04  
   4. Sub System       : SCE  
   5. Author           : 김인수  
   6. Description      : VVD 로 Vessel 의 현재 진행 상태를 구문으로 return 한다.  
   7. Revision History : 2011.01.04 김인수 최초 생성  
*******************************************************************************/  
  
RETURN VARCHAR2  
authid current_user   
IS  
    v_sts_rmk VARCHAR2(100);  
  
BEGIN  
      
select RMK INTO v_sts_rmk  
FROM (  
    SELECT case when port_skd_sts_cd = 'B' then 'The vessel arrived in ' || b.loc_nm || ' Port on ' || to_char(evnt_dt, 'dd. Mon. hh24:mi', 'NLS_DATE_LANGUAGE = AMERICAN') when port_skd_sts_cd = 'A' then 'The vessel is approaching ' || b.loc_nm || ' Port on ' || to_char(evnt_dt, 'dd. Mon. hh24:mi', 'NLS_DATE_LANGUAGE = AMERICAN') when port_skd_sts_cd = 'D'  
      and globaldate_pkg.time_conv_fnc('KRPUS', sysdate, vps_port_cd) - evnt_dt <= (3/24) then 'The vessel has departed to ' || c.LOC_NM || ' and ETB of Next Port is ' || to_char(next_init_etb, 'dd. Mon. hh24:mi', 'NLS_DATE_LANGUAGE = AMERICAN') when port_skd_sts_cd = 'D'  
      and globaldate_pkg.time_conv_fnc('KRPUS', sysdate, vps_port_cd) - evnt_dt > (3/24) then 'The vessel is heading out to ' || c.LOC_NM || ' and ETB of Next Port is ' || to_char(next_init_etb, 'dd. Mon. hh24:mi', 'NLS_DATE_LANGUAGE = AMERICAN') end as rmk ,  
      EVNT_DT  
    from (  
        select b.vsl_cd,  
          b.skd_voy_no,  
          b.skd_dir_cd,  
          b.vps_port_cd,  
          b.yd_cd,  
          a.clpt_ind_seq,  
          a.port_skd_sts_cd,  
          decode (a.port_skd_sts_cd, 'A', a.act_arr_dt, 'B', a.act_brth_dt, 'D', a.act_dep_dt) as evnt_dt,  
          lead (b.vps_eta_dt) over (  
            order by vps_eta_dt) as next_eta,  
          lead (b.init_etb_dt) over (  
            order by init_etb_dt) as next_init_etb,  
          b.vps_eta_dt,  
          b.vps_etb_dt,  
          b.vps_etd_dt,  
          lead (decode (a.port_skd_sts_cd, 'A', a.act_arr_dt, 'B', a.act_brth_dt, 'D', a.act_dep_dt)) over (  
            order by vps_eta_dt) as next_act,  
          lead (b.vps_port_cd) over (  
            order by vps_eta_dt) as next_port,  
          lead (b.yd_cd) over (  
            order by vps_eta_dt) as next_yd  
        from vsk_act_port_skd a,  
          vsk_vsl_port_skd b  
        where a.vsl_cd (+) = b.vsl_cd  
          and a.skd_voy_no (+) = b.skd_voy_no  
          and a.skd_dir_cd (+) = b.skd_dir_cd  
          and a.vps_port_cd (+) = b.vps_port_cd  
          and a.clpt_ind_seq (+) = b.clpt_ind_seq  
          and b.vsl_cd = v_vsl_cd  
          and b.skd_voy_no = v_skd_voy_no  
          and b.skd_dir_cd = v_skd_dir_cd ) a,  
      MDM_LOCATION b,  
      MDM_LOCATION c  
    where evnt_dt is not null  
      and next_act is null  
      and a.VPS_PORT_CD = b.LOC_CD  
      and a.NEXT_PORT = c.LOC_CD  
    ORDER BY EVNT_DT DESC )  
WHERE ROWNUM = 1;  
  
RETURN v_sts_rmk;  
  
END;
/
