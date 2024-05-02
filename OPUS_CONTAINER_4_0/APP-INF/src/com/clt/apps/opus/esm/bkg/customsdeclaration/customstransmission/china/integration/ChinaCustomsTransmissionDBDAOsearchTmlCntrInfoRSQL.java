/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchTmlCntrInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier :
*@LastVersion : 1.0
* 2009.11.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchTmlCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * TmlCntrVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchTmlCntrInfoRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n");
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchTmlCntrInfoRSQL").append("\n");
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
		query.append("SELECT  CNTR.CNTR_NO           CNTR_NO" ).append("\n");
		query.append(",TPSZ.CNTR_TPSZ_ISO_CD  CNTR_TYPE" ).append("\n");
		query.append(",CNTR.CNTR_WGT          NET_WGT" ).append("\n");
		query.append("FROM    BKG_CONTAINER CNTR," ).append("\n");
		query.append("MDM_CNTR_TP_SZ TPSZ" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND		CNTR.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND	    CNTR.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD" ).append("\n");

	}
}