/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCheckCntrForMoveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.08 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCheckCntrForMoveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCheckCntrForMoveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCheckCntrForMoveRSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("AND    B.BKG_NO = @[tgt_bkg_no]" ).append("\n"); 
		query.append("AND    A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    A.BKG_CGO_TP_CD = B.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("AND    NVL(A.PRE_RLY_PORT_CD, A.POL_CD) = NVL(B.PRE_RLY_PORT_CD, B.POL_CD)" ).append("\n"); 
		query.append("AND    NVL(A.PST_RLY_PORT_CD, A.POD_CD) = NVL(B.PST_RLY_PORT_CD, B.POD_CD)" ).append("\n"); 

	}
}