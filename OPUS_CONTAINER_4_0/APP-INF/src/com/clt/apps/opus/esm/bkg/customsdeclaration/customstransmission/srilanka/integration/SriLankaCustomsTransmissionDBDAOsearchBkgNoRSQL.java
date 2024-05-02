/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOsearchBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.13 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOsearchBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카 세관 신고용 B/L의 Booking Number 및 Cargo Type Code 를 조회한다.
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOsearchBkgNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration ").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOsearchBkgNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO, BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM  BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BL_NO      = @[bl_no]" ).append("\n"); 

	}
}