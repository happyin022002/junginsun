/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.05
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.06.05 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPackingInstructionRegulationPackagingCodeList
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pck_cd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingCodeListRSQL").append("\n"); 
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
		query.append("##SELECT IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("##	,  IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("##	,  REGU_DP_NO" ).append("\n"); 
		query.append("##    ,  SUB_SEQ" ).append("\n"); 
		query.append("##    ,  PCK_TP_CD" ).append("\n"); 
		query.append("##    ,  IMDG_PCK_CD" ).append("\n"); 
		query.append("##    ,  IMDG_PCK_DESC" ).append("\n"); 
		query.append("##    ,  IN_PKG_QTY" ).append("\n"); 
		query.append("##    ,  IN_PKG_MEAS_UT" ).append("\n"); 
		query.append("##    ,  OUT_PKG_QTY" ).append("\n"); 
		query.append("##    ,  OUT_PKG_MEAS_UT" ).append("\n"); 
		query.append("##FROM SCG_PCK_REGU_PKG_CD" ).append("\n"); 
		query.append("##WHERE 1=1" ).append("\n"); 
		query.append("##AND   IMDG_PCK_INSTR_CD = @[f_pck_cd]" ).append("\n"); 
		query.append("##AND   IMDG_PCK_INSTR_SEQ = @[f_pck_cd_seq]" ).append("\n"); 
		query.append("##AND   REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 
		query.append("##AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("##ORDER BY REGU_DP_NO, SUB_SEQ" ).append("\n"); 

	}
}