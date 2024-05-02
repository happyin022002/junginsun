/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BSAManageDBDAORemovemultiChgSlotSwapDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.16 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAORemovemultiChgSlotSwapDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0122 화면의 BSA_SPC-CTRL_SWAP DELETE 쿼리
	  * </pre>
	  */
	public BSAManageDBDAORemovemultiChgSlotSwapDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration ").append("\n"); 
		query.append("FileName : BSAManageDBDAORemovemultiChgSlotSwapDSQL").append("\n"); 
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
		query.append("DELETE FROM BSA_SPC_CTRL_SWAP" ).append("\n"); 
		query.append("WHERE	TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND	RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND	DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND	VOP_CD = @[vop_cd]" ).append("\n"); 
		query.append("AND	VSL_CAPA = @[vsl_capa]" ).append("\n"); 
		query.append("AND	BSA_SEQ = @[bsa_seq]" ).append("\n"); 
		query.append("AND	BSA_OP_CD = @[bsa_op_cd]" ).append("\n"); 
		query.append("AND	BSA_OP_JB_CD = @[bsa_op_jb_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}