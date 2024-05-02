/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2013.02.15 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterStatusData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterStatusDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER SET" ).append("\n"); 
		query.append("(LST_STS_SEQ, CNTR_STS_CD,LST_STS_YD_CD) = (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XAK1MST_CNTR_STS_HIS) */ A.CNTR_STS_SEQ, A.CNTR_STS_CD, A.YD_CD" ).append("\n"); 
		query.append("FROM   MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",	CRNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append(",	LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("#if (${st_cd} == '0' || ${st_cd} == '1' || ${st_cd} == '3' || ${st_cd} == '5' || ${st_cd} == '7')" ).append("\n"); 
		query.append(",	CNMV_STS_CD = 'XX'" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${st_cd} == '2' || ${st_cd} == '4' || ${st_cd} == '6')" ).append("\n"); 
		query.append(",	CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append(",	ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append(",   UCLM_LS_DIV_CD 	= NULL" ).append("\n"); 
		query.append(",   UCLM_DT 		= NULL" ).append("\n"); 
		query.append(",   UCLM_FREE_DYS	= NULL" ).append("\n"); 
		query.append(",   UCLM_END_DT		= NULL" ).append("\n"); 
		query.append(",   UCLM_RSN		= NULL" ).append("\n"); 
		query.append(",   UCLM_PLN_RMK	= NULL" ).append("\n"); 
		query.append(",   UCLM_CNTC_PNT_NM = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",   (SCC_CD, ECC_CD, LCC_CD, RCC_CD) = (SELECT A.SCC_CD,B.ECC_CD,B.LCC_CD,B.RCC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION A, MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = SUBSTR(@[sts_evnt_yd_cd], 1, 5)" ).append("\n"); 
		query.append("AND   A.SCC_CD = B.SCC_CD)" ).append("\n"); 
		query.append(",   CNTR_RMK = @[cntr_rmk]" ).append("\n"); 
		query.append(",   FULL_FLG = DECODE(@[full_flg], 'F', 'Y', 'M', 'N')" ).append("\n"); 
		query.append("WHERE	CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}