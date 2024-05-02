/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOAddCtmMvmtMnlHisColCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOAddCtmMvmtMnlHisColCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201641731] VGM 항목 추가
	  *  - 사용자에 의해 변경된 Column 정보 저장
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOAddCtmMvmtMnlHisColCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_his_col_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_his_col_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOAddCtmMvmtMnlHisColCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_MNL_HIS_COL (" ).append("\n"); 
		query.append("  CNTR_NO," ).append("\n"); 
		query.append("  CNMV_YR," ).append("\n"); 
		query.append("  CNMV_ID_NO," ).append("\n"); 
		query.append("  CNMV_HIS_SEQ," ).append("\n"); 
		query.append("  CNMV_HIS_COL_SEQ," ).append("\n"); 
		query.append("  CNMV_COL_NM," ).append("\n"); 
		query.append("  CRE_USR_ID," ).append("\n"); 
		query.append("  CRE_DT," ).append("\n"); 
		query.append("  UPD_USR_ID," ).append("\n"); 
		query.append("  UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("  @[cntr_no]," ).append("\n"); 
		query.append("  @[cnmv_yr]," ).append("\n"); 
		query.append("  @[cnmv_id_no]," ).append("\n"); 
		query.append("  @[cnmv_his_seq]," ).append("\n"); 
		query.append("  @[cnmv_his_col_seq]," ).append("\n"); 
		query.append("  @[cnmv_his_col_nm]," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE," ).append("\n"); 
		query.append("  @[cre_usr_id]," ).append("\n"); 
		query.append("  SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}