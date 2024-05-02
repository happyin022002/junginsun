/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBaplieAlarmSetupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.29 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBaplieAlarmSetupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBaplieAlarmSetup Search
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBaplieAlarmSetupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBaplieAlarmSetupRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD, LST_PORT_CD, SLAN_CD HIDDEN_SLAN_CD, LST_PORT_CD HIDDEN_LST_PORT_CD, " ).append("\n"); 
		query.append("RCVR_EML, RCVR_EML HIDDEN_RCVR_EML, EML_SND_USR_ID, EML_SND_HRS, USR_NM, OFC_CD, 'ETD + ' ETD" ).append("\n"); 
		query.append(",'' USER_ID" ).append("\n"); 
		query.append(",'' USER_NM" ).append("\n"); 
		query.append("FROM BKG_CSTMS_STWG_ALRM_STUP, COM_USER" ).append("\n"); 
		query.append("WHERE EML_SND_USR_ID = USR_ID(+)" ).append("\n"); 
		query.append("#if (${user_id} != '') " ).append("\n"); 
		query.append("AND EML_SND_USR_ID = @[user_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[ofc_cd]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${user_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(USR_NM) LIKE UPPER(@[user_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND UPPER(SLAN_CD) = UPPER(@[slan_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lst_port_cd} != '')" ).append("\n"); 
		query.append("AND UPPER(LST_PORT_CD) = UPPER(@[lst_port_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rcvr_eml} != '')" ).append("\n"); 
		query.append("AND UPPER(RCVR_EML) = UPPER(@[rcvr_eml])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}