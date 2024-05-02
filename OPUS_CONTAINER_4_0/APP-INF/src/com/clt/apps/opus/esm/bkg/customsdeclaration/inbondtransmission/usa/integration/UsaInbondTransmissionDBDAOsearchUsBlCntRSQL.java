/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchUsBlCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.04
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.04 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchUsBlCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim Us bl 건수를 확인.
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchUsBlCntRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchUsBlCntRSQL").append("\n"); 
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
		query.append("SELECT    COUNT(A.BL_NO)" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_ADV_BL A, BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("WHERE  A.BL_NO  = IBD.BL_NO" ).append("\n"); 
		query.append("AND    A.CNT_CD = IBD.CNT_CD" ).append("\n"); 
		query.append("AND    A.POD_CD LIKE 'US%'" ).append("\n"); 
		query.append("AND    IBD.CSTMS_CLR_TP_CD    IN ('I','L')" ).append("\n"); 
		query.append("AND    A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND    A.CNT_CD = 'US'" ).append("\n"); 

	}
}