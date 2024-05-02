/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchContactIFTSAIInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchContactIFTSAIInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Contact Info 조회
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchContactIFTSAIInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchContactIFTSAIInfoRSQL").append("\n"); 
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
		query.append("SELECT  X.RCVR_USR_ID USR_ID" ).append("\n"); 
		query.append("       ,(SELECT C.USR_NM FROM COM_USER C WHERE C.USR_ID = X.RCVR_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("       ,X.OFC_PHN_NO XTN_PHN_NO" ).append("\n"); 
		query.append("       ,X.OFC_FAX_NO FAX_NO" ).append("\n"); 
		query.append("       ,X.RCVR_EML USR_EML" ).append("\n"); 
		query.append("FROM      BKG_CLL_CNG_NTFY_SET X" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.OFC_CD        IN ('PUSSC','KANKS','INCKS')" ).append("\n"); 
		query.append("AND       X.PORT_CD              = @[port_cd]" ).append("\n"); 
		query.append("AND       X.SLAN_CD              = @[lane_cd] " ).append("\n"); 
		query.append("AND       X.DIR_CD               = @[dir_cd]" ).append("\n"); 
		query.append("AND       ROWNUM = 1" ).append("\n"); 

	}
}