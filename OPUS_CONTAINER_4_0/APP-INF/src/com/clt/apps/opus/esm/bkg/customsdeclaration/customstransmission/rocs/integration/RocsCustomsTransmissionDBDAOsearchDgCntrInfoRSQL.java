/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RocsCustomsTransmissionDBDAOsearchDgCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsCustomsTransmissionDBDAOsearchDgCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROCS(ROTTERDAM) 세관 신고용
	  * </pre>
	  */
	public RocsCustomsTransmissionDBDAOsearchDgCntrInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.integration").append("\n"); 
		query.append("FileName : RocsCustomsTransmissionDBDAOsearchDgCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("             IMDG_CLSS_CD DG_IMO_CLASS," ).append("\n"); 
		query.append("             IMDG_UN_NO DG_UNNO," ).append("\n"); 
		query.append("             to_char(FLSH_PNT_CDO_TEMP) DG_FLASH_PNT," ).append("\n"); 
		query.append("             PRP_SHP_NM DG_PKG_DESC," ).append("\n"); 
		query.append("             IMDG_PCK_GRP_CD PKGGRP" ).append("\n"); 
		query.append(" FROM   BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}