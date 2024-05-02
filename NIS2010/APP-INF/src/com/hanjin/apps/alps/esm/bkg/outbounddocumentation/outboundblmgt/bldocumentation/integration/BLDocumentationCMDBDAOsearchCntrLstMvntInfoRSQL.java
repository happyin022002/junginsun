/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking에 Attach 된 혹은 될 예정인 Container 기준 이전에 발생한 Movement Status 정보를 조회한다.
	  * </pre>
	  */
	public BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOsearchCntrLstMvntInfoRSQL").append("\n"); 
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
		query.append("SELECT  /*+ ORDERED INDEX_DESC(CTM XPKCTM_MOVEMENT ) */ BKG_NO,CNTR_NO,MVMT_STS_CD AS CNMV_STS_CD,CNMV_CYC_NO" ).append("\n"); 
		query.append("     FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("WHERE CTM.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("AND   CTM.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}