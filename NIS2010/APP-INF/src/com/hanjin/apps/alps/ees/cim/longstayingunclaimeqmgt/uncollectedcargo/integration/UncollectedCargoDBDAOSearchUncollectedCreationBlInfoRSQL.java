/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedCreationBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedCreationBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Uncollected Cargo Creation 에서 B/L 정보 조회 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedCreationBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedCreationBlInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT	 b.vsl_cd||b.skd_voy_no||b.skd_dir_cd vvd" ).append("\n"); 
		query.append("		, ( SELECT vsl_eng_nm FROM mdm_vsl_cntr WHERE vsl_cd = b.vsl_cd ) vsl_nm" ).append("\n"); 
		query.append("		, b.por_cd por" ).append("\n"); 
		query.append("		, (	SELECT	TO_CHAR(NVL(MAX(evnt_dt),''),'YYYYMMDD')" ).append("\n"); 
		query.append("			FROM	BKG_DO_DTL dtl," ).append("\n"); 
		query.append("    				BKG_BOOKING bkg" ).append("\n"); 
		query.append("			WHERE	1 = 1" ).append("\n"); 
		query.append("					AND dtl.bkg_no = b.bl_no" ).append("\n"); 
		query.append("	    			AND bkg.bkg_no = dtl.bkg_no" ).append("\n"); 
		query.append("	    			AND dtl.rlse_sts_cd = DECODE(SUBSTR(bkg.del_cd, 1, 2), 'JP', 'D', 'R')" ).append("\n"); 
		query.append("		  ) uc_do_iss_dt" ).append("\n"); 
		query.append("		, (	SELECT	NVL(MIN(mm.cnmv_evnt_dt),'')" ).append("\n"); 
		query.append("			FROM	CIM_UC_CGO_CNTR cc, CTM_MOVEMENT mm, BKG_BOOKING bb" ).append("\n"); 
		query.append("			WHERE	1 = 1" ).append("\n"); 
		query.append("					AND cc.bl_no = b.bl_no" ).append("\n"); 
		query.append("	    			AND mm.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("	    			AND cc.bl_no = bb.bkg_no" ).append("\n"); 
		query.append("	    			AND mm.trnk_vsl_cd||mm.trnk_skd_voy_no||mm.trnk_skd_dir_cd = b.vsl_cd||b.skd_voy_no||b.skd_dir_cd" ).append("\n"); 
		query.append("	    			AND mm.mvmt_sts_cd = 'OC'" ).append("\n"); 
		query.append("		  ) por_dt" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("             SELECT  MIN(bb.pol_cd)" ).append("\n"); 
		query.append("             FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("             WHERE   1 = 1" ).append("\n"); 
		query.append("                     AND kk.bl_no = b.bl_no" ).append("\n"); 
		query.append("                     AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                     AND kk.pol_cd = bb.pol_cd" ).append("\n"); 
		query.append("                     AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                     AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                     AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                     AND bb.pol_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pol" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("             SELECT  MIN(TO_CHAR(vv.vps_etd_dt,'YYYYMMDD'))" ).append("\n"); 
		query.append("             FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("             WHERE   1 = 1" ).append("\n"); 
		query.append("                     AND kk.bl_no = b.bl_no" ).append("\n"); 
		query.append("                     AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                     AND kk.pol_cd = bb.pol_cd" ).append("\n"); 
		query.append("                     AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                     AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                     AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                     AND bb.pol_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pol_etd" ).append("\n"); 
		query.append("        , ( " ).append("\n"); 
		query.append("            SELECT  MIN(bb.pod_cd)" ).append("\n"); 
		query.append("            FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND kk.bl_no = b.bl_no" ).append("\n"); 
		query.append("                    AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                    AND kk.pod_cd = bb.pod_cd" ).append("\n"); 
		query.append("                    AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                    AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                    AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                    AND bb.pod_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pod" ).append("\n"); 
		query.append("        , ( " ).append("\n"); 
		query.append("            SELECT  MIN(TO_CHAR(vv.vps_eta_dt,'YYYYMMDD'))" ).append("\n"); 
		query.append("            FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND kk.bl_no = b.bl_no" ).append("\n"); 
		query.append("                    AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                    AND kk.pod_cd = bb.pod_cd" ).append("\n"); 
		query.append("                    AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                    AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                    AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                    AND bb.pod_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pod_eta" ).append("\n"); 
		query.append("		, b.del_cd del_cd" ).append("\n"); 
		query.append("		, (	SELECT	NVL(MIN(mm.cnmv_evnt_dt),'')" ).append("\n"); 
		query.append("			FROM	CIM_UC_CGO_CNTR cc, CTM_MOVEMENT mm, BKG_BOOKING bb" ).append("\n"); 
		query.append("			WHERE	1 =1" ).append("\n"); 
		query.append("					AND cc.bl_no = b.bl_no" ).append("\n"); 
		query.append("	    			AND mm.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("	    			AND cc.bl_no = bb.bkg_no" ).append("\n"); 
		query.append("	    			AND mm.trnk_vsl_cd||mm.trnk_skd_voy_no||mm.trnk_skd_dir_cd = b.vsl_cd||b.skd_voy_no||b.skd_dir_cd" ).append("\n"); 
		query.append("	    			AND mm.mvmt_sts_cd = 'ID'" ).append("\n"); 
		query.append("		  ) del_dt" ).append("\n"); 
		query.append("		, ( SELECT	replace(substr(c.cust_nm,1,50),chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("         	FROM   	bkg_customer c" ).append("\n"); 
		query.append("         	WHERE  	b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("         			AND c.bkg_cust_tp_cd = 'S'" ).append("\n"); 
		query.append("       	  ) shpr" ).append("\n"); 
		query.append("		, ( SELECT 	replace(substr(c.cust_nm,1,50),chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("         	FROM   	bkg_customer c" ).append("\n"); 
		query.append("         	WHERE  	b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("         			AND c.bkg_cust_tp_cd = 'C'" ).append("\n"); 
		query.append("       	  ) cnee" ).append("\n"); 
		query.append("		, ( SELECT 	replace(substr(c.cust_nm,1,50),chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("         	FROM   	bkg_customer c" ).append("\n"); 
		query.append("         	WHERE  	b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("         			AND c.bkg_cust_tp_cd = 'N'" ).append("\n"); 
		query.append("       	  ) noti" ).append("\n"); 
		query.append("		, ( SELECT 	replace(substr(c.cust_nm,1,50),chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("         	FROM   	bkg_customer c" ).append("\n"); 
		query.append("         	WHERE  	b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("         			AND c.bkg_cust_tp_cd = 'F'" ).append("\n"); 
		query.append("       	  ) frwd" ).append("\n"); 
		query.append("		, ( SELECT 	c.cmdt_nm " ).append("\n"); 
		query.append("         	FROM 	mdm_commodity c " ).append("\n"); 
		query.append("         	WHERE 	c.cmdt_cd = b.cmdt_cd" ).append("\n"); 
		query.append("          ) cmdt" ).append("\n"); 
		query.append("		, (	SELECT	ROUND(SUM(NVL(R.CHG_AMT / DECODE(R.CURR_CD, 'USD', 1, " ).append("\n"); 
		query.append("            		( 	SELECT 	NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("             			FROM 	GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("             			WHERE 	R.CURR_CD = EX1.CURR_CD " ).append("\n"); 
		query.append("               					AND EX1.ACCT_XCH_RT_YRMON =" ).append("\n"); 
		query.append("                  							( 	SELECT	SUBSTR(TO_CHAR(NVL(MIN(S.VPS_ETB_DT),''), 'YYYYMM'), 1, 6)" ).append("\n"); 
		query.append("                   								FROM	VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                   								WHERE	S.VSL_CD = b.VSL_CD" ).append("\n"); 
		query.append("                  										AND	S.SKD_VOY_NO = b.SKD_VOY_NO" ).append("\n"); 
		query.append("                  										AND S.SKD_DIR_CD = b.SKD_DIR_CD" ).append("\n"); 
		query.append("                  										AND S.VPS_PORT_CD = b.POL_CD" ).append("\n"); 
		query.append("                 							 )" ).append("\n"); 
		query.append("               					AND EX1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("             	   )),0)), 2)" ).append("\n"); 
		query.append("			FROM	BKG_CHG_RT R" ).append("\n"); 
		query.append("      		WHERE	b.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("       				AND R.FRT_TERM_CD = 'P'" ).append("\n"); 
		query.append("     	   ) prepaid" ).append("\n"); 
		query.append("		, ( SELECT	ROUND(SUM(NVL(R.CHG_AMT / DECODE(R.CURR_CD, 'USD', 1, " ).append("\n"); 
		query.append("            		(	SELECT	NVL(EX1.USD_LOCL_XCH_RT, 1) " ).append("\n"); 
		query.append("             			FROM 	GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("             			WHERE 	R.CURR_CD = EX1.CURR_CD " ).append("\n"); 
		query.append("               					AND	EX1.ACCT_XCH_RT_YRMON =" ).append("\n"); 
		query.append("                  						(	SELECT	SUBSTR(TO_CHAR(NVL(MIN(S.VPS_ETB_DT),''), 'YYYYMM'), 1, 6)" ).append("\n"); 
		query.append("                   							FROM	VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                   							WHERE	S.VSL_CD = b.VSL_CD" ).append("\n"); 
		query.append("                  									AND S.SKD_VOY_NO = b.SKD_VOY_NO" ).append("\n"); 
		query.append("                  									AND S.SKD_DIR_CD = b.SKD_DIR_CD" ).append("\n"); 
		query.append("                  									AND S.VPS_PORT_CD = b.POL_CD" ).append("\n"); 
		query.append("                 						)" ).append("\n"); 
		query.append("               					AND EX1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("             		)),0)), 2)" ).append("\n"); 
		query.append("      		FROM	BKG_CHG_RT R" ).append("\n"); 
		query.append("      		WHERE	b.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("       				AND R.FRT_TERM_CD = 'C'" ).append("\n"); 
		query.append("     	  ) collect" ).append("\n"); 
		query.append("FROM	BKG_BOOKING b" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("		AND bl_no = @[bl_no]" ).append("\n"); 

	}
}