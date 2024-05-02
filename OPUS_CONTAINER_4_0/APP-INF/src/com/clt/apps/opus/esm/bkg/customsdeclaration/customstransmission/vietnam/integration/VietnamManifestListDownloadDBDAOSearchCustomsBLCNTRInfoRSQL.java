/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VietnamManifestListDownloadDBDAOSearchCustomsBLCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.27 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VietnamManifestListDownloadDBDAOSearchCustomsBLCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomsBLCNTRInfo
	  * </pre>
	  */
	public VietnamManifestListDownloadDBDAOSearchCustomsBLCNTRInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.integration").append("\n"); 
		query.append("FileName : VietnamManifestListDownloadDBDAOSearchCustomsBLCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT BC.CNTR_NO   BL_CNTRNBR" ).append("\n"); 
		query.append(",BD.PCK_QTY     BL_PKG_QTY" ).append("\n"); 
		query.append("FROM      BKG_BOOKING B" ).append("\n"); 
		query.append(", BKG_BL_DOC BD" ).append("\n"); 
		query.append(", BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND       B.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND       BD.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND       BC.BKG_NO = BD.BKG_NO" ).append("\n"); 

	}
}