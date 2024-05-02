/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAOSearchVndrSeqCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.12 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOSearchVndrSeqCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVndrSeqCheck
	  * </pre>
	  */
	public FFCmpnAuditDBDAOSearchVndrSeqCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.integration ").append("\n"); 
		query.append("FileName : FFCmpnAuditDBDAOSearchVndrSeqCheckRSQL").append("\n"); 
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
		query.append("/* Vendor의 MDM_VENDOR를 조회한다. */" ).append("\n"); 
		query.append("SELECT '*' VENDOR " ).append("\n"); 
		query.append("  FROM MDM_VENDOR " ).append("\n"); 
		query.append(" WHERE VNDR_SEQ = @[vndr_seq] " ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}