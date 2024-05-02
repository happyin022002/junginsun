/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOSearchDgGoodsInfoRSQL").append("\n"); 
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
		query.append("SELECT    DG.IMDG_CLSS_CD HAZARD_CD" ).append("\n"); 
		query.append("         ,DG.IMDG_UN_NO UNDG_NO" ).append("\n"); 
		query.append("         ,DG.FLSH_PNT_CDO_TEMP FLASH_POINT " ).append("\n"); 
		query.append("FROM      BKG_CONTAINER C, BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       DG.BKG_NO = C.BKG_NO " ).append("\n"); 
		query.append("AND	      DG.CNTR_NO = C.CNTR_NO" ).append("\n"); 

	}
}