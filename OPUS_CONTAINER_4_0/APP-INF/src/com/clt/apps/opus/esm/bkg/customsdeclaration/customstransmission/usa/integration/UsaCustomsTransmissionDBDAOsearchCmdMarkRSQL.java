/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCmdMarkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCmdMarkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCmdMarkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCmdMarkRSQL").append("\n"); 
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
		query.append("SELECT NVL(TRIM(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(MK_DESC),' '),'X')),'NO MARKS') cmd_mark_all" ).append("\n"); 
		query.append("	  ,LENGTH(NVL(TRIM(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(MK_DESC),' '),'M')),'NO MARKS')) cmd_mark_len" ).append("\n"); 
		query.append("      ,NVL(TRIM(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(MK_DESC),' '),'M')),'NO MARKS') MK_DESC" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_ADV_CNTR_MF" ).append("\n"); 
		query.append("WHERE BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("	AND CNTR_NO    = TRIM(@[cntr_no])" ).append("\n"); 
		query.append("	AND CMDT_GDS_SEQ    = TRIM(@[cmd_seq])" ).append("\n"); 
		query.append("	AND CNT_CD = 'US'" ).append("\n"); 

	}
}