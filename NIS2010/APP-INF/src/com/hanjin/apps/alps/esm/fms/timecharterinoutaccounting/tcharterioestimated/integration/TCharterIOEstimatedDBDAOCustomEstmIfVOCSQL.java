/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("est_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hire_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_ioc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("days",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acc_old_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOCustomEstmIfVOCSQL").append("\n"); 
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
		query.append("#if (${est_type} == 'PV') " ).append("\n"); 
		query.append("	INSERT INTO GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("	     (" ).append("\n"); 
		query.append("	       EXE_YRMON,              	SYS_SRC_ID,             REV_YRMON,              ACCT_CD," ).append("\n"); 
		query.append("	       ESTM_SEQ_NO,            	" ).append("\n"); 
		query.append("	       BIZ_UT_ID,              " ).append("\n"); 
		query.append("	       LOC_CD,                 " ).append("\n"); 
		query.append("	       VSL_CD,					SKD_VOY_NO,				SKD_DIR_CD,				REV_DIR_CD," ).append("\n"); 
		query.append("	       VVD_DUR_NO,             	HIR_DT_AMT,           	ESTM_AMT,               ACT_AMT," ).append("\n"); 
		query.append("	       ACCL_AMT,            	ESTM_VVD_TP_CD,         ESTM_IOC_DIV_CD,        ESTM_VVD_HDR_ID,       	ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("		   CRE_USR_ID,				CRE_DT,					UPD_USR_ID,				UPD_DT" ).append("\n"); 
		query.append("	     )" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	       @[exe_yrmon],          	'CDA',                  @[rev_yrmon],           decode(@[flet_ctrt_tp_cd], 'TO', '411211', '510911')," ).append("\n"); 
		query.append("	       @[estm_seq_no],                " ).append("\n"); 
		query.append("	       'CNTR',                 " ).append("\n"); 
		query.append("	       (SELECT LOC_CD from MDM_ORGANIZATION WHERE OFC_CD = @[slp_ofc_cd])," ).append("\n"); 
		query.append("		   @[vsl_cd], 				@[skd_voy_no], 			@[skd_dir_cd], 			@[rev_dir_cd]," ).append("\n"); 
		query.append("	       @[days],                 @[hire_amt],            @[est_amt],             0," ).append("\n"); 
		query.append("	       0,              			ESTM_VVD_TP_CD,         ESTM_IOC_DIV_CD,        DECODE(ESTM_VVD_HDR_ID, 0, NULL, ESTM_VVD_HDR_ID), ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("		   @[cre_usr_id],			SYSDATE,				@[cre_usr_id],			SYSDATE	" ).append("\n"); 
		query.append("	FROM   GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("	WHERE 	EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("	AND 	REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("	AND		VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND		SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND		SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND		REV_DIR_CD = @[rev_dir_cd]" ).append("\n"); 
		query.append("	AND 	ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("	AND 	ESTM_IOC_DIV_CD = @[estm_ioc_div_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	INSERT INTO GL_ESTM_IF_ERP" ).append("\n"); 
		query.append("	     (" ).append("\n"); 
		query.append("	       EXE_YRMON,              	SYS_SRC_ID,             REV_YRMON,              ACCT_CD," ).append("\n"); 
		query.append("	       ESTM_SEQ_NO,            	" ).append("\n"); 
		query.append("	       BIZ_UT_ID,              " ).append("\n"); 
		query.append("	       LOC_CD,                 " ).append("\n"); 
		query.append("	       VSL_CD,					SKD_VOY_NO,				SKD_DIR_CD,				REV_DIR_CD," ).append("\n"); 
		query.append("	       VVD_DUR_NO,             	HIR_DT_AMT,           	ESTM_AMT,               ACT_AMT," ).append("\n"); 
		query.append("	       ACCL_AMT,            	FLET_ACCL_AMT,			ESTM_VVD_TP_CD,         ESTM_IOC_DIV_CD,        ESTM_VVD_HDR_ID,       	ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("		   CRE_USR_ID,				CRE_DT,					UPD_USR_ID,				UPD_DT" ).append("\n"); 
		query.append("	     )" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	       @[exe_yrmon],          'CDA',                  @[rev_yrmon],           decode(@[flet_ctrt_tp_cd], 'TO', '411211', '510911')," ).append("\n"); 
		query.append("	       @[estm_seq_no],                " ).append("\n"); 
		query.append("	       'CNTR',                 " ).append("\n"); 
		query.append("	       (SELECT LOC_CD from MDM_ORGANIZATION WHERE OFC_CD = @[slp_ofc_cd])," ).append("\n"); 
		query.append("		   SUBSTR(@[vvd_cd], 1, 4), SUBSTR(@[vvd_cd], 5, 4)," ).append("\n"); 
		query.append("	       DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 9, 1), " ).append("\n"); 
		query.append("					DECODE(SUBSTR(@[vvd_cd], 9, 1), 'A', 'E', 'B', 'E', 'E', 'E', 'K', 'E', 'Q', 'E', 'C', 'W', 'D', 'W', 'F', 'W', 'U', 'W', 'W', 'W', SUBSTR(@[vvd_cd], 9, 1)))," ).append("\n"); 
		query.append("	       DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 10, 1), SUBSTR(@[vvd_cd], 9, 1)), " ).append("\n"); 
		query.append("	       @[days],                   @[hire_amt],              @[est_amt],                   @[act_amt]," ).append("\n"); 
		query.append("	       @[acc_amt],                @[acc_old_amt],		ESTM_VVD_TP_CD,           ESTM_IOC_DIV_CD,              DECODE(ESTM_VVD_HDR_ID, 0, NULL, ESTM_VVD_HDR_ID), ESTM_BC_DIV_CD," ).append("\n"); 
		query.append("		   @[cre_usr_id],			  SYSDATE,					@[cre_usr_id],			  	  SYSDATE	" ).append("\n"); 
		query.append("	FROM   (SELECT  ESTM_VVD_TP_CD, ESTM_IOC_DIV_CD, ESTM_VVD_HDR_ID, ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("			  FROM  GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("             WHERE  EXE_YRMON = DECODE(SUBSTR(@[exe_yrmon], 1, 4), SUBSTR(@[rev_yrmon], 1, 4), @[exe_yrmon], SUBSTR(@[exe_yrmon], 1, 4)-1||'12')" ).append("\n"); 
		query.append("               AND  REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("			   AND  VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			   AND  SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			   AND  SKD_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 9, 1),DECODE(SUBSTR(@[vvd_cd], 9, 1), 'A', 'E', 'B', 'E', 'E', 'E', 'K', 'E', 'Q', 'E', 'C', 'W', 'D', 'W', 'F', 'W', 'U', 'W', 'W', 'W', SUBSTR(@[vvd_cd], 9, 1)))" ).append("\n"); 
		query.append("			   AND  REV_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 10, 1), SUBSTR(@[vvd_cd], 9, 1))" ).append("\n"); 
		query.append("			   AND  ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("			 UNION  ALL" ).append("\n"); 
		query.append("			SELECT  ESTM_VVD_TP_CD, ESTM_IOC_DIV_CD, ESTM_VVD_HDR_ID, ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("			  FROM  GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("			 WHERE  EXE_YRMON = DECODE(SUBSTR(@[exe_yrmon], 1, 4), SUBSTR(@[rev_yrmon], 1, 4), @[exe_yrmon], SUBSTR(@[exe_yrmon], 1, 4)-1||'12') " ).append("\n"); 
		query.append("               AND  REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("			   AND  VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("			   AND  SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			   AND  SKD_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 9, 1),DECODE(SUBSTR(@[vvd_cd], 9, 1), 'A', 'E', 'B', 'E', 'E', 'E', 'K', 'E', 'Q', 'E', 'C', 'W', 'D', 'W', 'F', 'W', 'U', 'W', 'W', 'W', SUBSTR(@[vvd_cd], 9, 1)))" ).append("\n"); 
		query.append("			   AND  REV_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 10, 1), SUBSTR(@[vvd_cd], 9, 1))" ).append("\n"); 
		query.append("			   AND  ESTM_IOC_DIV_CD <> 'OO'" ).append("\n"); 
		query.append("			   AND  NOT EXISTS (SELECT  NULL  FROM  GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("							 	 WHERE  VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("							       AND  SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("			   					   AND  SKD_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 9, 1),DECODE(SUBSTR(@[vvd_cd], 9, 1), 'A', 'E', 'B', 'E', 'E', 'E', 'K', 'E', 'Q', 'E', 'C', 'W', 'D', 'W', 'F', 'W', 'U', 'W', 'W', 'W', SUBSTR(@[vvd_cd], 9, 1)))" ).append("\n"); 
		query.append("							       AND  REV_DIR_CD = DECODE(LENGTHB(@[vvd_cd]), 10, SUBSTR(@[vvd_cd], 10, 1), SUBSTR(@[vvd_cd], 9, 1))" ).append("\n"); 
		query.append("                                   AND ESTM_IOC_DIV_CD = 'OO' " ).append("\n"); 
		query.append("                                   AND EXE_YRMON = DECODE(SUBSTR(@[exe_yrmon], 1, 4), SUBSTR(@[rev_yrmon], 1, 4), @[exe_yrmon], SUBSTR(@[exe_yrmon], 1, 4)-1||'12')" ).append("\n"); 
		query.append("                                   AND REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("			 ORDER  BY 1 DESC" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}