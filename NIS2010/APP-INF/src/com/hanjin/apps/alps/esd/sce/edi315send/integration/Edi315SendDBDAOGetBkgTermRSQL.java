/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetBkgTermRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.08 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetBkgTermRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for getBkgTerm
	  * </pre>
	  */
	public Edi315SendDBDAOGetBkgTermRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetBkgTermRSQL").append("\n"); 
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
		query.append("select b.RCV_TERM_CD||b.DE_TERM_CD RD_TERM , b.SC_NO, b.SLAN_CD, l.VSL_SLAN_NM" ).append("\n"); 
		query.append(", to_char(b.cre_dt,'YYYYMMDDHH24MISS')  panto_cre_dt" ).append("\n"); 
		query.append("from bkg_booking b, MDM_VSL_SVC_LANE l" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and b.bkg_no = @[e_bkg_no]" ).append("\n"); 
		query.append("AND b.SLAN_CD = L.VSL_SLAN_CD(+)" ).append("\n"); 

	}
}