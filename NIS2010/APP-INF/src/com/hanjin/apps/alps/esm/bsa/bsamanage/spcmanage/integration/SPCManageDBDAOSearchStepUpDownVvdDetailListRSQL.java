/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SPCManageDBDAOSearchStepUpDownVvdDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.03.25 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchStepUpDownVvdDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BSA_0032 Step Up/Down by VVD  화면의 Detail 조회 쿼리
	  * </pre>
	  */
	public SPCManageDBDAOSearchStepUpDownVvdDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetvsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetskd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheettrd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetcrr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetskd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetbsa_op_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sheetrlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchStepUpDownVvdDetailListRSQL").append("\n"); 
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
		query.append("      TRD_CD, " ).append("\n"); 
		query.append("      RLANE_CD, " ).append("\n"); 
		query.append("      VSL_CD, " ).append("\n"); 
		query.append("      SKD_VOY_NO, " ).append("\n"); 
		query.append("      SKD_DIR_CD, " ).append("\n"); 
		query.append("      BSA_OP_JB_CD, " ).append("\n"); 
		query.append("      CRR_CD, " ).append("\n"); 
		query.append("      PORT_SEQ, " ).append("\n"); 
		query.append("      PORT_CD, " ).append("\n"); 
		query.append("      PORT_BSA_CAPA " ).append("\n"); 
		query.append(" FROM   " ).append("\n"); 
		query.append("      BSA_VVD_PORT_DWN " ).append("\n"); 
		query.append(" WHERE  TRD_CD       = @[sheettrd_cd] " ).append("\n"); 
		query.append(" AND    RLANE_CD     = @[sheetrlane_cd] " ).append("\n"); 
		query.append(" AND    VSL_CD       = @[sheetvsl_cd] " ).append("\n"); 
		query.append(" AND    SKD_VOY_NO   = @[sheetskd_voy_no] " ).append("\n"); 
		query.append(" AND    SKD_DIR_CD   = @[sheetskd_dir_cd] " ).append("\n"); 
		query.append(" AND    BSA_OP_JB_CD = @[sheetbsa_op_jb_cd] " ).append("\n"); 
		query.append(" AND    CRR_CD       = @[sheetcrr_cd]" ).append("\n"); 
		query.append(" AND    PORT_SEQ     <> 999" ).append("\n"); 

	}
}