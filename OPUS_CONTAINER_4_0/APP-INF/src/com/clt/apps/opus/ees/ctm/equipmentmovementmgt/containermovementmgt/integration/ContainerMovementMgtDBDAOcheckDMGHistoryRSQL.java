/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckDMGHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckDMGHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkDMGHistory
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckDMGHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckDMGHistoryRSQL").append("\n"); 
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
		query.append("SELECT EQ_NO, " ).append("\n"); 
		query.append("	MNR_STS_FLG, " ).append("\n"); 
		query.append("	MNR_FLG_YD_CD, " ).append("\n"); 
		query.append("	TO_CHAR(MNR_FLG_INP_DT, 'YYYYMMDDHH24MI') AS MNR_FLG_INP_DT," ).append("\n"); 
		query.append("	MNR_FLG_RMK," ).append("\n"); 
		query.append("	UPD_OFC_CD," ).append("\n"); 
		query.append("	UPD_USR_ID" ).append("\n"); 
		query.append("FROM MNR_FLG_HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND EQ_KND_CD='U'" ).append("\n"); 
		query.append("AND MNR_FLG_TP_CD = 'DMG'" ).append("\n"); 
		query.append("#if (${evnt_dt} != '') " ).append("\n"); 
		query.append("AND MNR_FLG_SEQ = (SELECT MAX(MNR_FLG_SEQ) - @[seq] - 1" ).append("\n"); 
		query.append("        FROM MNR_FLG_HIS" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND EQ_KND_CD='U'" ).append("\n"); 
		query.append("        AND MNR_FLG_TP_CD = 'DMG')" ).append("\n"); 
		query.append("AND MNR_FLG_INP_DT > TO_DATE(@[evnt_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("AND MNR_STS_FLG = DECODE(@[dmg_flg], '1', 'N', 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MNR_FLG_SEQ = (SELECT MAX(MNR_FLG_SEQ) - @[seq]" ).append("\n"); 
		query.append("        FROM MNR_FLG_HIS" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND EQ_NO = @[cntr_no]" ).append("\n"); 
		query.append("        AND EQ_KND_CD='U'" ).append("\n"); 
		query.append("        AND MNR_FLG_TP_CD = 'DMG')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}