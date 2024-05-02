/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOSearchBBApprovalStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOSearchBBApprovalStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Booking No의 Application 신청 및 승인에 대한 Status를 보여주는 화면
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOSearchBBApprovalStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("booking_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOSearchBBApprovalStatusListRSQL").append("\n"); 
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
		query.append("--::2016-04-19::--" ).append("\n"); 
		query.append("SELECT * FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	DECODE(A.VSL_PRE_PST_CD,'S','Pre'||A.VSL_SEQ,'T','Trunk','U','Post'||A.VSL_SEQ) AS VSL_PRE_PST_NM," ).append("\n"); 
		query.append("	A.SPCL_CGO_APRO_RQST_SEQ," ).append("\n"); 
		query.append("	A.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("	A.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("	C.SPCL_CGO_AUTH_SEQ," ).append("\n"); 
		query.append("	A.VSL_SEQ,	" ).append("\n"); 
		query.append("	A.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("	A.SLAN_CD," ).append("\n"); 
		query.append("	A.VSL_CD," ).append("\n"); 
		query.append("	A.SKD_VOY_NO," ).append("\n"); 
		query.append("	A.SKD_DIR_CD," ).append("\n"); 
		query.append("	A.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("	A.BKG_NO," ).append("\n"); 
		query.append("	A.BKG_STS_CD," ).append("\n"); 
		query.append("	A.BB_CGO_SEQ," ).append("\n"); 
		query.append("	DECODE(A.SPCL_BKG_RQST_FLG, 'Y','S','')||'R'||A.SPCL_CGO_RQST_SEQ AS RQST_AUTH_CD," ).append("\n"); 
		query.append("	A.RQST_OFC_CD," ).append("\n"); 
		query.append("	TO_CHAR(A.RQST_DT,'YYYY-MM-DD') AS RQST_DT,	" ).append("\n"); 
		query.append("	TO_CHAR(A.RQST_GDT,'YYYY-MM-DD') AS RQST_GDT,	" ).append("\n"); 
		query.append("	A.RQST_USR_ID," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D','D','C','C',DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','C',C.SPCL_CGO_AUTH_CD),C.SPCL_CGO_AUTH_CD)) AS SPCL_CGO_AUTH_CD," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'',(SELECT TO_CHAR(A.RQST_DT,'YYYY-MM-DD') FROM SCG_APRO_RQST H WHERE H.BKG_NO = A.BKG_NO AND H.SPCL_CGO_CATE_CD = A.SPCL_CGO_CATE_CD AND H.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ),TO_CHAR(C.AUTH_DT,'YYYY-MM-DD')),TO_CHAR(C.AUTH_DT,'YYYY-MM-DD')) AS AUTH_DT," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'',(SELECT TO_CHAR(A.RQST_GDT,'YYYY-MM-DD') FROM SCG_APRO_RQST H WHERE H.BKG_NO = A.BKG_NO AND H.SPCL_CGO_CATE_CD = A.SPCL_CGO_CATE_CD AND H.SPCL_CGO_RQST_SEQ = A.SPCL_CGO_RQST_SEQ),TO_CHAR(C.AUTH_GDT,'YYYY-MM-DD')),TO_CHAR(C.AUTH_GDT,'YYYY-MM-DD')) AS AUTH_GDT," ).append("\n"); 
		query.append("	DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','SYSTEM',C.AUTH_USR_ID),C.AUTH_USR_ID) AS AUTH_USR_ID," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D',C.SPCL_CGO_AUTH_RJCT_CD,'C',C.SPCL_CGO_AUTH_RJCT_CD,DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','SYS',C.SPCL_CGO_AUTH_RJCT_CD),C.SPCL_CGO_AUTH_RJCT_CD)) AS SPCL_CGO_AUTH_RJCT_CD," ).append("\n"); 
		query.append("	DECODE(A.SPCL_CGO_APRO_CD,'D',C.SPCL_CGO_AUTH_RMK,'C',C.SPCL_CGO_AUTH_RMK,DECODE(A.LST_RQST_DAT_FLG,'N',DECODE(C.SPCL_CGO_AUTH_CD,'','Reapplication',C.SPCL_CGO_AUTH_RMK),C.SPCL_CGO_AUTH_RMK)) AS SPCL_CGO_AUTH_RMK," ).append("\n"); 
		query.append("	A.POL_CD," ).append("\n"); 
		query.append("	A.POD_CD," ).append("\n"); 
		query.append("    C.APRO_REF_NO," ).append("\n"); 
		query.append("    A.CMDT_NM," ).append("\n"); 
		query.append("    A.DIM_LEN," ).append("\n"); 
		query.append("    A.DIM_WDT," ).append("\n"); 
		query.append("    A.DIM_HGT," ).append("\n"); 
		query.append("    A.GRS_WGT," ).append("\n"); 
		query.append("    A.OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("    --::2016-04-19::--" ).append("\n"); 
		query.append("    ROW_NUMBER() OVER (PARTITION BY NVL(C.BKG_NO, A.BKG_NO), NVL(C.SPCL_CGO_APRO_RQST_SEQ, A.SPCL_CGO_APRO_RQST_SEQ), NVL(C.BB_CGO_SEQ, A.BB_CGO_SEQ), NVL(C.VSL_PRE_PST_CD, A.VSL_PRE_PST_CD), NVL(C.VSL_SEQ, A.VSL_SEQ)" ).append("\n"); 
		query.append("    ORDER BY DECODE(C.APRO_REF_NO,NULL,9,1), C.UPD_DT DESC) AS CORR_AUTH_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    	A.BKG_NO," ).append("\n"); 
		query.append("		A.BKG_STS_CD," ).append("\n"); 
		query.append("        A.OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("    	C.SLAN_CD," ).append("\n"); 
		query.append("    	B.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("    	B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("		B.SPCL_BKG_RQST_FLG," ).append("\n"); 
		query.append("        B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("    	B.RQST_OFC_CD," ).append("\n"); 
		query.append("    	B.RQST_DT," ).append("\n"); 
		query.append("    	B.RQST_GDT," ).append("\n"); 
		query.append("    	B.RQST_USR_ID," ).append("\n"); 
		query.append("		B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("    	C.VSL_CD," ).append("\n"); 
		query.append("    	C.SKD_VOY_NO," ).append("\n"); 
		query.append("    	C.SKD_DIR_CD," ).append("\n"); 
		query.append("        C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        C.VSL_SEQ," ).append("\n"); 
		query.append("    	C.POL_CD," ).append("\n"); 
		query.append("    	C.POD_CD," ).append("\n"); 
		query.append("		D.BB_CGO_SEQ," ).append("\n"); 
		query.append("    	( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = D.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("    	D.DIM_LEN," ).append("\n"); 
		query.append("	    D.DIM_WDT," ).append("\n"); 
		query.append("    	D.DIM_HGT," ).append("\n"); 
		query.append("	    D.GRS_WGT," ).append("\n"); 
		query.append("		D.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM BKG_BOOKING A, SCG_APRO_RQST B, SCG_VVD_APRO_RQST C, SCG_BB_CGO D" ).append("\n"); 
		query.append("	WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_CATE_CD = 'BB'" ).append("\n"); 
		query.append("	AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_APRO_RQST_SEQ = C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_APRO_RQST_SEQ = D.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("	AND B.LST_RQST_DAT_FLG = 'N'" ).append("\n"); 
		query.append("--	AND D.SPCL_CGO_APRO_CD is not null" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[booking_no]" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '' && ${vsl_cd} != 'null')" ).append("\n"); 
		query.append("	AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    	A.BKG_NO," ).append("\n"); 
		query.append("		A.BKG_STS_CD," ).append("\n"); 
		query.append("        A.OVR_VOID_SLT_QTY," ).append("\n"); 
		query.append("    	C.SLAN_CD," ).append("\n"); 
		query.append("    	B.SPCL_CGO_APRO_RQST_SEQ, " ).append("\n"); 
		query.append("    	B.SPCL_CGO_CATE_CD," ).append("\n"); 
		query.append("		B.SPCL_BKG_RQST_FLG," ).append("\n"); 
		query.append("        B.SPCL_CGO_RQST_SEQ," ).append("\n"); 
		query.append("    	B.RQST_OFC_CD," ).append("\n"); 
		query.append("    	B.RQST_DT," ).append("\n"); 
		query.append("    	B.RQST_GDT," ).append("\n"); 
		query.append("    	B.RQST_USR_ID," ).append("\n"); 
		query.append("		B.LST_RQST_DAT_FLG," ).append("\n"); 
		query.append("    	C.VSL_CD," ).append("\n"); 
		query.append("    	C.SKD_VOY_NO," ).append("\n"); 
		query.append("    	C.SKD_DIR_CD," ).append("\n"); 
		query.append("        C.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("        C.VSL_SEQ," ).append("\n"); 
		query.append("    	C.POL_CD," ).append("\n"); 
		query.append("    	C.POD_CD," ).append("\n"); 
		query.append("		D.BB_CGO_SEQ," ).append("\n"); 
		query.append("    	( SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = D.CMDT_CD) AS CMDT_NM," ).append("\n"); 
		query.append("    	D.DIM_LEN," ).append("\n"); 
		query.append("	    D.DIM_WDT," ).append("\n"); 
		query.append("    	D.DIM_HGT," ).append("\n"); 
		query.append("	    D.GRS_WGT," ).append("\n"); 
		query.append("		D.SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	FROM BKG_BOOKING A, SCG_APRO_RQST B, SCG_VVD_APRO_RQST C, BKG_BB_CGO D" ).append("\n"); 
		query.append("	WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_CATE_CD = 'BB'" ).append("\n"); 
		query.append("	AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	AND B.SPCL_CGO_APRO_RQST_SEQ = C.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("	AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("	AND B.LST_RQST_DAT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-07-06::--AND D.SPCL_CGO_APRO_CD is not null" ).append("\n"); 
		query.append("	--::2015-07-06::--AND D.SPCL_CGO_APRO_CD not in ('C','D')" ).append("\n"); 
		query.append("    --::2016-04-19::--		" ).append("\n"); 
		query.append("	AND D.SPCL_CGO_APRO_CD <> 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[booking_no]" ).append("\n"); 
		query.append("	#if (${vsl_cd} != '' && ${vsl_cd} != 'null')" ).append("\n"); 
		query.append("	AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("	AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A, SCG_AUTHORIZATION C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.SPCL_CGO_APRO_RQST_SEQ = C.SPCL_CGO_APRO_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND A.VSL_PRE_PST_CD = C.VSL_PRE_PST_CD(+)" ).append("\n"); 
		query.append("AND A.VSL_SEQ = C.VSL_SEQ(+)" ).append("\n"); 
		query.append("AND A.BB_CGO_SEQ = C.BB_CGO_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.SPCL_CGO_RQST_SEQ, A.VSL_PRE_PST_CD, A.VSL_SEQ, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD," ).append("\n"); 
		query.append("         A.BKG_NO, A.BB_CGO_SEQ ASC" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AA.CORR_AUTH_SEQ = 1" ).append("\n"); 

	}
}