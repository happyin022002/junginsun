/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BSAManageDBDAOSearchSpcScPortDownDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.02 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchSpcScPortDownDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpcScPortDownDetailList SELECT
	  * </pre>
	  */
	public BSAManageDBDAOSearchSpcScPortDownDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchSpcScPortDownDetailListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.BSA_SEQ" ).append("\n"); 
		query.append(",A.BSA_FM_DT" ).append("\n"); 
		query.append(",B.TRD_CD" ).append("\n"); 
		query.append(",B.RLANE_CD" ).append("\n"); 
		query.append(",B.DIR_CD" ).append("\n"); 
		query.append(",B.VSL_SEQ" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",B.BSA_OP_CD" ).append("\n"); 
		query.append(",B.BSA_OP_JB_CD" ).append("\n"); 
		query.append(",B.CRR_CD" ).append("\n"); 
		query.append(",B.PORT_SEQ" ).append("\n"); 
		query.append(",B.PORT_CD" ).append("\n"); 
		query.append(",B.PORT_BSA_CAPA" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BSA_SLT_CHTR_BZC A," ).append("\n"); 
		query.append("BSA_SLT_CHTR_PORT_DWN B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.BSA_SEQ       = B.BSA_SEQ" ).append("\n"); 
		query.append("AND A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD        = B.DIR_CD" ).append("\n"); 
		query.append("AND A.TRD_CD        = B.TRD_CD" ).append("\n"); 
		query.append("AND A.VSL_SEQ       = B.VSL_SEQ" ).append("\n"); 
		query.append("AND B.BSA_SEQ       = @[bsa_seq]" ).append("\n"); 
		query.append("AND B.TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("AND B.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("AND B.DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("AND B.VSL_SEQ       = @[vsl_seq]" ).append("\n"); 
		query.append("AND B.BSA_OP_CD     = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND B.BSA_OP_JB_CD  = @[bsa_op_jb_cd]" ).append("\n"); 
		query.append("AND B.CRR_CD        = @[crr_cd]" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.BSA_FM_DT," ).append("\n"); 
		query.append("B.TRD_CD," ).append("\n"); 
		query.append("B.RLANE_CD," ).append("\n"); 
		query.append("B.DIR_CD," ).append("\n"); 
		query.append("B.VSL_SEQ," ).append("\n"); 
		query.append("B.PORT_SEQ" ).append("\n"); 

	}
}