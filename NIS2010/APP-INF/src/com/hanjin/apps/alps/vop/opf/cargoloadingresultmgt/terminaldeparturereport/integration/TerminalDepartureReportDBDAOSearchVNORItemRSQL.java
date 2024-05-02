/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchVNORItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchVNORItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VNOR Item을 조회한다.
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchVNORItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vnor_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchVNORItemRSQL").append("\n"); 
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
		query.append("-- Main Item(Off-Hire Time)" ).append("\n"); 
		query.append("SELECT	VNOR_ITM_SEQ" ).append("\n"); 
		query.append("		,VNOR_MN_ITM_FLG" ).append("\n"); 
		query.append("		,VNOR_ITM_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_VAL" ).append("\n"); 
		query.append("		,VNOR_ITM_STS_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_RMK" ).append("\n"); 
		query.append("		,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("		,ATCH_FILE_KNT" ).append("\n"); 
		query.append("FROM OPF_VNOR VNOR, OPF_VNOR_ITM ITM" ).append("\n"); 
		query.append("WHERE VNOR.VSL_CD = ITM.VSL_CD" ).append("\n"); 
		query.append("AND VNOR.VNOR_SEQ = ITM.VNOR_SEQ" ).append("\n"); 
		query.append("AND VNOR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND VNOR.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("AND ITM.VNOR_MN_ITM_FLG = 'Y'" ).append("\n"); 
		query.append("AND ITM.VNOR_ITM_CD = 'OH'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("-- Sub Item" ).append("\n"); 
		query.append("SELECT	VNOR_ITM_SEQ" ).append("\n"); 
		query.append("		,VNOR_MN_ITM_FLG" ).append("\n"); 
		query.append("		,VNOR_ITM_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_OFC_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_UT_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_VAL" ).append("\n"); 
		query.append("		,VNOR_ITM_STS_CD" ).append("\n"); 
		query.append("		,VNOR_ITM_RMK" ).append("\n"); 
		query.append("		,ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("		,ATCH_FILE_KNT" ).append("\n"); 
		query.append("FROM OPF_VNOR VNOR, OPF_VNOR_ITM ITM" ).append("\n"); 
		query.append("WHERE VNOR.VSL_CD = ITM.VSL_CD" ).append("\n"); 
		query.append("AND VNOR.VNOR_SEQ = ITM.VNOR_SEQ" ).append("\n"); 
		query.append("AND VNOR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND VNOR.VNOR_SEQ = @[vnor_seq]" ).append("\n"); 
		query.append("AND ITM.VNOR_MN_ITM_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY VNOR_ITM_SEQ" ).append("\n"); 

	}
}