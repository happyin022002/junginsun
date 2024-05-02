/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.24 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchKrWhfBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchKrWhfBlInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration ").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchKrWhfBlInfoRSQL").append("\n"); 
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
		query.append("SELECT  A.CUST_NM" ).append("\n"); 
		query.append(",A.CUST_NM" ).append("\n"); 
		query.append(",B.CSTMS_DESC" ).append("\n"); 
		query.append(",C.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CUSTOMER A" ).append("\n"); 
		query.append(",BKG_CUSTOMER E" ).append("\n"); 
		query.append(",BKG_BL_DOC B" ).append("\n"); 
		query.append(",BKG_BOOKING C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD = 'E'" ).append("\n"); 
		query.append("AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM < 10" ).append("\n"); 

	}
}