/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchBlDangerCntrRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : Hannah Lee
*@LastVersion : 1.0
* 2014.06.23 Hannah Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hannah Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchBlDangerCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ChinaBlDangerCntrListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchBlDangerCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchBlDangerCntrRSQL").append("\n");
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
		query.append("SELECT  BL_NO" ).append("\n");
		query.append("	   	,CHN_MF_SND_IND_CD" ).append("\n");
		query.append("	   	,CNTR_NO" ).append("\n");
		query.append("       	,IMDG_CLSS_CD" ).append("\n");
		query.append("       	,IMDG_PG_NO" ).append("\n");
		query.append("       	,IMDG_UN_NO" ).append("\n");
		query.append("       	,IMDG_SUBS_RSK_LBL_CD" ).append("\n");
		query.append("	 	,CNTC_PSON_NM" ).append("\n");
		query.append("		,CNTC_PSON_TELCM_NO" ).append("\n");
		query.append("FROM    BKG_CSTMS_CHN_DG_CGO" ).append("\n");
		query.append("WHERE   BL_NO 			  = @[bl_no]" ).append("\n");
		query.append("AND     CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n");
		query.append("ORDER BY CNTR_NO " ).append("\n");

	}
}