/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDAOSearchBkgXterRqstNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDAOSearchBkgXterRqstNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG의 최신 XterRqstNo를 가져온다
	  * </pre>
	  */
	public Edi315SendDAOSearchBkgXterRqstNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDAOSearchBkgXterRqstNoRSQL").append("\n"); 
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
		query.append("SELECT MST.XTER_RQST_NO RQST_NO" ).append("\n"); 
		query.append(", MAX(MST.XTER_RQST_SEQ) RQST_SEQ" ).append("\n"); 
		query.append(", MST.XTER_SNDR_ID SENDER_ID" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST MST, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO		 = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.XTER_BKG_RQST_REF_NO = MST.XTER_RQST_NO" ).append("\n"); 
		query.append("AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("GROUP BY MST.XTER_RQST_NO, MST.XTER_SNDR_ID" ).append("\n"); 

	}
}