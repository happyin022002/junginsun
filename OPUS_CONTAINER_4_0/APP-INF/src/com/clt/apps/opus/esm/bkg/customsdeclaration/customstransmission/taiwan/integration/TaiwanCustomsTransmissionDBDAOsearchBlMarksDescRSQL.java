/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchBlMarksDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchBlMarksDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest B/L Marks, Description 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchBlMarksDescRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchBlMarksDescRSQL").append("\n"); 
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
		query.append("SELECT	DOC.PCK_CMDT_DESC||CHR(10)||" ).append("\n"); 
		query.append("DOC.CNTR_CMDT_DESC||CHR(10)||" ).append("\n"); 
		query.append("BMD.CMDT_DESC tmpstr4," ).append("\n"); 
		query.append("BMD.MK_DESC tmpstr5" ).append("\n"); 
		query.append("FROM BKG_BL_MK_DESC BMD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE	DOC.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("AND     DOC.BKG_NO = BMD.BKG_NO" ).append("\n"); 

	}
}