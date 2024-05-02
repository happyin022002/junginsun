/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOmodifyCntrStatusHistoryByMvmtDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.05.03 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOmodifyCntrStatusHistoryByMvmtDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCntrStatusHistoryByMvmtData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOmodifyCntrStatusHistoryByMvmtDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOmodifyCntrStatusHistoryByMvmtDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CNTR_STS_HIS" ).append("\n"); 
		query.append("SET (YD_CD," ).append("\n"); 
		query.append("     LOC_CD," ).append("\n"); 
		query.append("     SCC_CD," ).append("\n"); 
		query.append("     LCC_CD," ).append("\n"); 
		query.append("     ECC_CD," ).append("\n"); 
		query.append("     RCC_CD," ).append("\n"); 
		query.append("     CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("     CNTR_STS_RMK," ).append("\n"); 
		query.append("     UPD_USR_ID," ).append("\n"); 
		query.append("     UPD_DT," ).append("\n"); 
		query.append("     CNTR_AUTH_NO) =" ).append("\n"); 
		query.append("    (SELECT DECODE(@[new_flg],'C','KRSEL1H',@[org_yd_cd])," ).append("\n"); 
		query.append("            DECODE(@[new_flg],'C','KRSEL',SUBSTR(@[org_yd_cd], 1, 5)), " ).append("\n"); 
		query.append("            Z.SCC_CD," ).append("\n"); 
		query.append("            Z.LCC_CD," ).append("\n"); 
		query.append("            Z.ECC_CD," ).append("\n"); 
		query.append("            Z.RCC_CD," ).append("\n"); 
		query.append("            TRUNC(TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDD HH24:MI'))," ).append("\n"); 
		query.append("            DECODE(@[new_flg],'C','NEW VAN PICK-UP  CANCEL','NEW VAN PICK-UP')," ).append("\n"); 
		query.append("            @[upd_usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            NULL" ).append("\n"); 
		query.append("     FROM MDM_LOCATION L, MDM_EQ_ORZ_CHT Z" ).append("\n"); 
		query.append("     WHERE DECODE(@[new_flg],'C','KRSEL',SUBSTR(@[org_yd_cd],1,5)) = L.LOC_CD" ).append("\n"); 
		query.append("     AND   L.SCC_CD = Z.SCC_CD)" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND   CNTR_STS_CD IN('LSI','OWN')" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}