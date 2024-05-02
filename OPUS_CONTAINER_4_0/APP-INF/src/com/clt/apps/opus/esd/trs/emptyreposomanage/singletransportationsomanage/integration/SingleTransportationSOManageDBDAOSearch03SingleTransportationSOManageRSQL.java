/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.06.28 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_SVC_ORD, EQR_REPO_EXE_SO_IF, MST_CONTAINER  테이블 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sstoreqdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfrmreqdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfrmnode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stransmodcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stonode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlofccd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearch03SingleTransportationSOManageRSQL").append("\n"); 
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
		query.append("SELECT A.REPO_PLN_ID" ).append("\n"); 
		query.append("      ,A.PLN_YRWK" ).append("\n"); 
		query.append("      ,A.PLN_SEQ" ).append("\n"); 
		query.append("      ,A.REF_ID" ).append("\n"); 
		query.append("      ,A.REF_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,B.REPO_PURP_RMK" ).append("\n"); 
		query.append("      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append("      ,DECODE(A.TRSP_COST_DTL_MOD_CD, 'CN', 'On-Hire', 'CF', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,(C.AGMT_CTY_CD || C.AGMT_SEQ) LESSOR" ).append("\n"); 
		query.append("      ,C.LSTM_CD" ).append("\n"); 
		query.append("      ,A.OWNR_CO_CD" ).append("\n"); 
		query.append("      ,C.CNTR_USE_CO_CD EQ_USED" ).append("\n"); 
		query.append("      ,C.CNMV_STS_CD MOVEMENT_STS" ).append("\n"); 
		query.append("      ,C.CRNT_YD_CD CREATION_YARD" ).append("\n"); 
		query.append("      ,TO_CHAR(C.CNMV_DT, 'YYYY-MM-DD') EVENT_DATE" ).append("\n"); 
		query.append("      ,TO_CHAR(A.TRSP_MTY_RQST_DT, 'YYYYMMDDHH24MISS') TRSP_MTY_RQST_DT" ).append("\n"); 
		query.append("      ,A.INTER_RMK" ).append("\n"); 
		query.append("      ,A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD A, EQR_REPO_EXE_SO_IF B, MST_CONTAINER C" ).append("\n"); 
		query.append("		WHERE A.REPO_PLN_ID = B.REPO_PLN_ID " ).append("\n"); 
		query.append("		AND A.PLN_YRWK = B.PLN_YRWK " ).append("\n"); 
		query.append("		AND A.REF_ID = B.REF_ID " ).append("\n"); 
		query.append("		AND A.REF_SEQ = B.REF_SEQ " ).append("\n"); 
		query.append("		AND A.EQ_NO = C.CNTR_NO(+) " ).append("\n"); 
		query.append("		AND A.TRSP_SO_TP_CD = 'M' " ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD = @[sctrlofccd] " ).append("\n"); 
		query.append("#if (${sradWoIssued} == 'YES')" ).append("\n"); 
		query.append("        AND A.TRSP_SO_STS_CD = 'I' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND A.DELT_FLG = 'N' " ).append("\n"); 
		query.append("#if (${sfrmreqdate} != '' && ${sstoreqdate} != '')" ).append("\n"); 
		query.append("	#if (${srad_date} == 'R')" ).append("\n"); 
		query.append("		AND A.TRSP_MTY_RQST_DT BETWEEN TO_DATE(@[sfrmreqdate], 'YYYYMMDD') AND TO_DATE(@[sstoreqdate], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[sfrmreqdate], 'YYYYMMDD') AND TO_DATE(@[sstoreqdate], 'YYYYMMDD') + 0.99999 	" ).append("\n"); 
		query.append("	#end 	  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk} == 'OK' && ((${skind} != 'ALL') || (${stransmodcd} != 'ALL') || (${sfrmnode} != '') || (${stonode} != '') || ($arrCntr.size() > 0)  || ($arrReferencno.size() > 0))) " ).append("\n"); 
		query.append(" AND ( 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${skind} != 'ALL')" ).append("\n"); 
		query.append("	AND (A.TRSP_MTY_COST_MOD_CD = @[skind])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stransmodcd} != 'ALL')" ).append("\n"); 
		query.append(" AND (A.TRSP_CRR_MOD_CD = @[stransmodcd]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sfrmnode} != '')" ).append("\n"); 
		query.append("	AND (A.FM_NOD_CD LIKE @[sfrmnode]||'%' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Multi From Node로 조회" ).append("\n"); 
		query.append("#if ($arr_fmnode.size() > 0) " ).append("\n"); 
		query.append("    AND A.FM_NOD_CD in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_fmnode}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_fmnode.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stonode} != '')" ).append("\n"); 
		query.append("	AND (A.TO_NOD_CD LIKE @[stonode]||'%' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Multi To Node로 조회" ).append("\n"); 
		query.append("#if ($arr_tonode.size() > 0) " ).append("\n"); 
		query.append("    AND A.TO_NOD_CD in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_tonode}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_tonode.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrCntr.size() > 0) " ).append("\n"); 
		query.append("   AND (A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach($cntrKey in ${arrCntr}) " ).append("\n"); 
		query.append("	#if($velocityCount < $arrCntr.size()) " ).append("\n"); 
		query.append("		'$cntrKey'," ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		'$cntrKey'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  ))                             " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrReferencno.size() > 0) " ).append("\n"); 
		query.append("   AND (A.REF_ID IN (" ).append("\n"); 
		query.append("#foreach($referKey in ${arrReferencno}) " ).append("\n"); 
		query.append("	#if($velocityCount < $arrReferencno.size()) " ).append("\n"); 
		query.append("		'$referKey'," ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		'$referKey'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  ))                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($arrBkgno.size() > 0) " ).append("\n"); 
		query.append("   AND (A.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($referKey in ${arrBkgno}) " ).append("\n"); 
		query.append("	#if($velocityCount < $arrBkgno.size()) " ).append("\n"); 
		query.append("		'$referKey'," ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("		'$referKey'" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  ))                             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chk} == 'OK' && ((${skind} != 'ALL') || (${stransmodcd} != 'ALL') || (${sfrmnode} != '') || (${stonode} != '') || ($arrCntr.size() > 0)  || ($arrReferencno.size() > 0))) " ).append("\n"); 
		query.append("OR TRSP_SO_CMB_SEQ IN ( " ).append("\n"); 
		query.append("	#foreach($strcmbKey IN ${arrStrcmbseq}) " ).append("\n"); 
		query.append("		$strcmbKey," ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("	 0 ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.TRSP_SO_CMB_SEQ" ).append("\n"); 

	}
}