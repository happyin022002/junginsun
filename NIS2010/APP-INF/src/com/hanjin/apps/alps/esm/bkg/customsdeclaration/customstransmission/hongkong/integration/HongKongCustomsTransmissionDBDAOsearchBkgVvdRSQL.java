/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.02.19 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Booking VVD 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchBkgVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	'BVVD:'||NVL(VSL_CD,'')||NVL(SKD_VOY_NO,'')||NVL(SKD_DIR_CD,'') vvd_number," ).append("\n"); 
		query.append("	'BPOL:'||NVL(POL_CD,'') BPOL," ).append("\n"); 
		query.append("              'BPOD:'||NVL(POD_CD,'')||chr(10)||'}BKGVVD' BPOD  " ).append("\n"); 
		query.append("   FROM BKG_VVD" ).append("\n"); 
		query.append("   WHERE bkg_no        = @[bkg_no]" ).append("\n"); 

	}
}