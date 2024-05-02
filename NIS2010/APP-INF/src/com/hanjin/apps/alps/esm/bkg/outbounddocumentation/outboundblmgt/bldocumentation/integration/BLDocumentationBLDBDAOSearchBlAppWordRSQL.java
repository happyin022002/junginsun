/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchBlAppWordRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.13 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchBlAppWordRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL에 특정 문구를 삽입하기 위해
	  * POD_CD, SLAN_CD, SKD_DIR)CD, SVC_SCP_CD를 조회한다
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchBlAppWordRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchBlAppWordRSQL").append("\n"); 
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
		query.append("SELECT BK.POD_CD" ).append("\n"); 
		query.append("	 , BK.SLAN_CD" ).append("\n"); 
		query.append("	 , BK.SKD_DIR_CD" ).append("\n"); 
		query.append("	 , BK.SVC_SCP_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND BK.BKG_NO =@[bkg_no]" ).append("\n"); 

	}
}