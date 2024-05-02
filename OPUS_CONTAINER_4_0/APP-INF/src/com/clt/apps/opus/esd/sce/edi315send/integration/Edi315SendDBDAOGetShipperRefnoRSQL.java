/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetShipperRefnoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.08 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetShipperRefnoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for getShipperRefno
	  * </pre>
	  */
	public Edi315SendDBDAOGetShipperRefnoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetShipperRefnoRSQL").append("\n"); 
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
		query.append("select REF_NO SH_REF_NBR" ).append("\n"); 
		query.append("from bkg_customer" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and BKG_NO        = @[e_bkg_no]" ).append("\n"); 
		query.append("and BKG_CUST_TP_CD  = 'S'" ).append("\n"); 

	}
}