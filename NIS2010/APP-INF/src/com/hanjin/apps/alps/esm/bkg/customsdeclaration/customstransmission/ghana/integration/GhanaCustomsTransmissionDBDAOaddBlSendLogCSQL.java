/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaCustomsTransmissionDBDAOaddBlSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaCustomsTransmissionDBDAOaddBlSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관에 Manifest 신고한 BL 전송 History를 생성한다.
	  * </pre>
	  */
	public GhanaCustomsTransmissionDBDAOaddBlSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mf_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.integration").append("\n"); 
		query.append("FileName : GhanaCustomsTransmissionDBDAOaddBlSendLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_GH_BL(" ).append("\n"); 
		query.append("MF_SND_DT" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", MF_SND_SEQ" ).append("\n"); 
		query.append(", VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("TO_DATE(@[mf_snd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(", substr(@[bl_no],1,12)" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(MF_SND_SEQ),0)" ).append("\n"); 
		query.append("FROM BKG_CSTMS_GH_BL" ).append("\n"); 
		query.append("WHERE BL_NO = substr(@[bl_no],1,12)) + 1" ).append("\n"); 
		query.append(", SUBSTR(@[vvd_cd], 1, 4), SUBSTR(@[vvd_cd], 5, 4), SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(", @[user_id], sysdate, @[user_id], sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}