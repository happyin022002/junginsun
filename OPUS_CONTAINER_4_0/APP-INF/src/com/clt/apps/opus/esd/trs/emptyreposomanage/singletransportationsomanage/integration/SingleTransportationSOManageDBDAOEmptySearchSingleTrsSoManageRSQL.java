/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOEmptySearchSingleTrsSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.12.16 박찬우
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

public class SingleTransportationSOManageDBDAOEmptySearchSingleTrsSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Repo S/O 조회 대상 그룹을 조회한다.
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOEmptySearchSingleTrsSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOEmptySearchSingleTrsSoManageRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.SO_IF_DIV_CD TRSP_COST_DTL_MOD_CD, " ).append("\n"); 
		query.append("	DECODE(A.SO_IF_DIV_CD, 'O', 'On-Hire', 'F', 'Off-Hire', 'Empty Repo') TRSP_COST_DTL_MOD_NAME, " ).append("\n"); 
		query.append("	A.REF_ID," ).append("\n"); 
		query.append("    A.BKG_NO," ).append("\n"); 
		query.append("	COUNT(A.REF_ID)  ALLOCATED,  " ).append("\n"); 
		query.append("	SUM( DECODE( SO.TRSP_SO_STS_CD ,'C',1,'R',1,0 )) CRET_QTY, " ).append("\n"); 
		query.append("	COUNT(SO.TRSP_WO_SEQ ) WO_QTY, " ).append("\n"); 
		query.append("	SUM( DECODE(SO.TRSP_SO_SEQ , NULL , 1, 0 )) REMAING_QTY, " ).append("\n"); 
		query.append("	A.TRSP_MOD_CD TRSP_CRR_MOD_CD, " ).append("\n"); 
		query.append("	DECODE(A.TRSP_MOD_CD, 'W', 'WD', 'T', 'TD', 'R', 'RD', '') TRSP_CRR_MOD_NAME, " ).append("\n"); 
		query.append("	A.FM_YD_CD FM_NOD_CD, " ).append("\n"); 
		query.append("	A.TO_YD_CD TO_NOD_CD, " ).append("\n"); 
		query.append("	A.CNTR_TPSZ_CD EQ_TPSZ_CD, " ).append("\n"); 
		query.append("	A.SO_RQST_DT REQUESTED_DATE " ).append("\n"); 
		query.append("FROM EQR_REPO_EXE_SO_IF A, " ).append("\n"); 
		query.append("     TRS_TRSP_SVC_ORD SO, " ).append("\n"); 
		query.append("     MDM_LOCATION LOC   " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    A.REPO_PLN_ID = SO.REPO_PLN_ID(+)	" ).append("\n"); 
		query.append("AND A.PLN_YRWK = SO.PLN_YRWK(+) 	" ).append("\n"); 
		query.append("AND A.REF_ID = SO.REF_ID(+) 		" ).append("\n"); 
		query.append("AND A.REF_SEQ = SO.REF_SEQ(+) 		" ).append("\n"); 
		query.append("AND LOC.LOC_CD = SUBSTR(A.FM_YD_CD, 1, 5)  " ).append("\n"); 
		query.append("AND A.TRSP_MOD_CD IN ('T', 'R', 'W')" ).append("\n"); 
		query.append("AND A.WO_RQST_FLG = 'Y'  " ).append("\n"); 
		query.append("AND A.CO_CD = 'H'  " ).append("\n"); 
		query.append("AND NVL(SO.DELT_FLG(+),'N')  <>'Y'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 1 FROM MDM_COUNTRY CNTY WHERE CNTY.CNT_CD IN('US', 'CA') AND A.TRSP_MOD_CD = 'R' AND LOC.CONTI_CD = 'M' AND LOC.CNT_CD = CNTY.CNT_CD)" ).append("\n"); 
		query.append("#if( !(${hid_frmreqdate} == '') && !(${hid_toreqdate} == '') )" ).append("\n"); 
		query.append("AND A.SO_RQST_DT BETWEEN '${hid_frmreqdate}' AND '${hid_toreqdate}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_ref.size() > 0) " ).append("\n"); 
		query.append("AND A.REF_ID IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_ref}) " ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append("		    '${key}'	" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		    , '${key}'" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_cntr.size() > 0) " ).append("\n"); 
		query.append("AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_cntr}) " ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append("		    '${key}'	" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		    , '${key}'" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_bkg.size() > 0) " ).append("\n"); 
		query.append("AND A.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bkg}) " ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append("		    '${key}'	" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		    , '${key}'" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($arr_office.size() > 0) " ).append("\n"); 
		query.append("AND A.EQ_CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_office}) " ).append("\n"); 
		query.append("			#if($velocityCount == 1)" ).append("\n"); 
		query.append("		    UPPER('${key}')	" ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		    , UPPER('${key}')" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( !(${sel_kind} == 'ALL') )" ).append("\n"); 
		query.append("	#if( ${sel_kind} == 'ER' )" ).append("\n"); 
		query.append("AND A.SO_IF_DIV_CD NOT IN ('F', 'O')  -- M:Empty Repo, O:On-Hire, F:Off-Hire" ).append("\n"); 
		query.append("	#elseif( ${sel_kind} == 'CN' )" ).append("\n"); 
		query.append("AND A.SO_IF_DIV_CD = 'O'			--M:Empty Repo, O:On-Hire, F:Off-Hire" ).append("\n"); 
		query.append("	#elseif( ${sel_kind} == 'CF' )" ).append("\n"); 
		query.append("AND A.SO_IF_DIV_CD = 'F'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( !(${frm_node} == '') )" ).append("\n"); 
		query.append("AND A.FM_YD_CD LIKE '${frm_node}'||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Multi From Node로 조회" ).append("\n"); 
		query.append("#if ($arr_fmnode.size() > 0) " ).append("\n"); 
		query.append("    AND A.FM_YD_CD in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_fmnode}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_fmnode.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( !(${to_node} == '') )" ).append("\n"); 
		query.append("AND A.TO_YD_CD LIKE '${to_node}'||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Multi To Node로 조회" ).append("\n"); 
		query.append("#if ($arr_tonode.size() > 0) " ).append("\n"); 
		query.append("    AND A.TO_YD_CD in (" ).append("\n"); 
		query.append("    #foreach( ${key} in ${arr_tonode}) " ).append("\n"); 
		query.append("	    #if($velocityCount < $arr_tonode.size()) " ).append("\n"); 
		query.append("	        '$key', " ).append("\n"); 
		query.append("	    #else " ).append("\n"); 
		query.append("            '$key' " ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( !(${cntr_type} == 'ALL') )" ).append("\n"); 
		query.append("AND SUBSTR(A.CNTR_TPSZ_CD, 1, 1) = '${cntr_type}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( !(${cntr_size} == 'ALL') )" ).append("\n"); 
		query.append("AND SUBSTR(A.CNTR_TPSZ_CD, 2, 1) = '${cntr_size}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.SO_IF_DIV_CD, A.REF_ID, A.BKG_NO," ).append("\n"); 
		query.append("	A.TRSP_MOD_CD, A.TRSP_MOD_CD, A.FM_YD_CD, A.TO_YD_CD, " ).append("\n"); 
		query.append("	A.CNTR_TPSZ_CD, A.SO_RQST_DT " ).append("\n"); 
		query.append("HAVING  SUM( DECODE(SO.TRSP_SO_SEQ , NULL , 1, 0 ))  <> 0	" ).append("\n"); 
		query.append("ORDER BY A.SO_IF_DIV_CD, A.SO_RQST_DT, A.REF_ID, A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}