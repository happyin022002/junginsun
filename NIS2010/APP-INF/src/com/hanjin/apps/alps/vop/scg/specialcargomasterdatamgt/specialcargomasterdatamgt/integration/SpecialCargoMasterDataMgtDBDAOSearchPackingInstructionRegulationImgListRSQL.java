/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationImgListRSQL.java
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

public class SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationImgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Image File List 조회
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationImgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_instr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("regu_dp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationImgListRSQL").append("\n"); 
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
		query.append("SELECT B.IMDG_PCK_INSTR_CD," ).append("\n"); 
		query.append("    B.IMDG_PCK_INSTR_SEQ," ).append("\n"); 
		query.append("    B.REGU_DP_NO," ).append("\n"); 
		query.append("    B.FILE_NM," ).append("\n"); 
		query.append("    TO_CHAR(B.UPD_DT, 'YYYY/MM/DD HH24:MI:SS') UPD_DT," ).append("\n"); 
		query.append("	B.SUB_SEQ" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("SCG_PCK_REGU_IMG B," ).append("\n"); 
		query.append("SCG_PCK_REGU A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.IMDG_PCK_INSTR_CD = B.IMDG_PCK_INSTR_CD" ).append("\n"); 
		query.append("AND A.IMDG_PCK_INSTR_SEQ = B.IMDG_PCK_INSTR_SEQ" ).append("\n"); 
		query.append("AND A.REGU_DP_NO = B.REGU_DP_NO" ).append("\n"); 
		query.append("#if (${imdg_pck_instr_cd} != '') " ).append("\n"); 
		query.append("AND   B.IMDG_PCK_INSTR_CD = @[imdg_pck_instr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_pck_instr_seq} != '') " ).append("\n"); 
		query.append("AND   B.IMDG_PCK_INSTR_SEQ = @[imdg_pck_instr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${regu_dp_no} != '') " ).append("\n"); 
		query.append("AND   B.REGU_DP_NO = @[regu_dp_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 

	}
}