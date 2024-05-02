/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchExportCntKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19 
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

public class KorCustomsTransmissionDBDAOsearchExportCntKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * O/B Local (= 'E')이면서 Simple B/L일 경우 한국세관 Elno Table에서 Data조회함 (Trans='E' & B/L Type = Simple)
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchExportCntKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchExportCntKorRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') CNT_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(SUM(NVL(CNTR_WGT,0)),0),'FM00000000.000') CNTR_WGT" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_XPT_LIC" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND    DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND    TRNS_SEQ = @[trns_seq]" ).append("\n"); 

	}
}