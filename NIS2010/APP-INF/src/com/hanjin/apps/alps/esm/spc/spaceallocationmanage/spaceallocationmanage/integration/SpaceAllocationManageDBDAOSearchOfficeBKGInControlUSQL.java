/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchOfficeBKGInControlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : Kim sung wook
*@LastVersion : 1.0
* 2015.06.11 Kim sung wook
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchOfficeBKGInControlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UPDATE Control Office BKG
	  * 2015.04.20 SMP 인경우와 아닌 경우 구분하여 처리하도록 수정
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchOfficeBKGInControlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ctrl_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ctrl_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchOfficeBKGInControlUSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_BKG_CTRL_OPT_DTL S" ).append("\n"); 
		query.append("USING(" ).append("\n"); 
		query.append("	SELECT TRD_CD" ).append("\n"); 
		query.append("	 FROM SPC_BKG_CTRL_OPT_DTL" ).append("\n"); 
		query.append("	WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("	  AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	  AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("	  AND RLANE_CD   = DECODE( BKG_CTRL_TP_CD , 'S' , RLANE_CD , @[rlane_cd] )" ).append("\n"); 
		query.append("	  AND BKG_CTRL_TP_CD = @[bkg_ctrl_tp_cd]" ).append("\n"); 
		query.append("	  AND BKG_CTRL_DTL_CD = @[bkg_ctrl_dtl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ON(" ).append("\n"); 
		query.append("	      S.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("	  AND S.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	  AND S.DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("	  AND S.RLANE_CD = DECODE( S.BKG_CTRL_TP_CD , 'S' , S.RLANE_CD , @[rlane_cd] )" ).append("\n"); 
		query.append("	  AND S.BKG_CTRL_TP_CD = @[bkg_ctrl_tp_cd]" ).append("\n"); 
		query.append("	  AND S.BKG_CTRL_DTL_CD = @[bkg_ctrl_dtl_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	S.BKG_CTRL_RTO = @[bkg_ctrl_rto]," ).append("\n"); 
		query.append("	S.BKG_CTRL_ACCT_FLG = DECODE(@[bkg_ctrl_acct_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" TRD_CD," ).append("\n"); 
		query.append(" SUB_TRD_CD," ).append("\n"); 
		query.append(" RLANE_CD," ).append("\n"); 
		query.append(" DIR_CD," ).append("\n"); 
		query.append(" BKG_CTRL_TP_CD," ).append("\n"); 
		query.append(" BKG_CTRL_DTL_CD," ).append("\n"); 
		query.append(" BKG_CTRL_RTO," ).append("\n"); 
		query.append(" BKG_CTRL_ACCT_FLG," ).append("\n"); 
		query.append(" CRE_USR_ID," ).append("\n"); 
		query.append(" CRE_DT," ).append("\n"); 
		query.append(" UPD_USR_ID," ).append("\n"); 
		query.append(" UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[trd_cd]," ).append("\n"); 
		query.append("@[sub_trd_cd]," ).append("\n"); 
		query.append("@[rlane_cd]," ).append("\n"); 
		query.append("@[dir_cd]," ).append("\n"); 
		query.append("@[bkg_ctrl_tp_cd]," ).append("\n"); 
		query.append("@[bkg_ctrl_dtl_cd]," ).append("\n"); 
		query.append("@[bkg_ctrl_rto]," ).append("\n"); 
		query.append("DECODE(@[bkg_ctrl_acct_flg], '1', 'Y', 'N')," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}