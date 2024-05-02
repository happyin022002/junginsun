/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortPairExceptionDBDAOSearchPortPairPartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortPairExceptionDBDAOSearchPortPairPartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PortPairPartner 를 찾는 select 문
	  * </pre>
	  */
	public PortPairExceptionDBDAOSearchPortPairPartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.integration ").append("\n"); 
		query.append("FileName : PortPairExceptionDBDAOSearchPortPairPartnerRSQL").append("\n"); 
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
		query.append("SELECT  S.CUST_TRD_PRNR_ID," ).append("\n"); 
		query.append("        P.CUST_TRD_PRNR_NM," ).append("\n"); 
		query.append("		S.CUST_TRD_PRNR_ID combo_Cd," ).append("\n"); 
		query.append("		S.CUST_TRD_PRNR_ID val," ).append("\n"); 
		query.append("		p.CUST_TRD_PRNR_NM Name," ).append("\n"); 
		query.append("		p.CUST_TRD_PRNR_NM desct" ).append("\n"); 
		query.append("FROM    VSK_CUST_SKD_EDI_SET    S," ).append("\n"); 
		query.append("        SCE_EDI_PRNR            P" ).append("\n"); 
		query.append("WHERE   ( S.EDI_SVC_TP_NM     =   'PORT'  OR S.CUST_TRD_PRNR_ID = 'DAK' )" ).append("\n"); 
		query.append("AND     S.USE_FLG           =   'Y'" ).append("\n"); 
		query.append("AND     S.CUST_TRD_PRNR_ID  =   P.CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append("AND     P.DELT_FLG          =   'N'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        P.CUST_TRD_PRNR_NM" ).append("\n"); 

	}
}