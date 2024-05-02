/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOCanonEmlBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2010.02.08 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOCanonEmlBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOCanonEmlBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOCanonEmlBkgRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO" ).append("\n"); 
		query.append(",      F.USR_ID" ).append("\n"); 
		query.append(",      F.USR_NM" ).append("\n"); 
		query.append(",      F.USR_EML" ).append("\n"); 
		query.append(",      F.OFC_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING A, BKG_CUSTOMER B, BKG_AUTO_EML_CUST C, BKG_VVD D, COM_SYS_AREA_GRP_ID E, COM_USER F" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND A.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND A.POL_CD = D.POL_CD" ).append("\n"); 
		query.append("AND A.POL_CD = C.POL_CD" ).append("\n"); 
		query.append("AND B.CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND B.CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND C.CO_NM = @[co_nm]" ).append("\n"); 
		query.append("AND D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND D.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND D.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' FROM BKG_AUTO_EML WHERE BKG_NO=A.BKG_NO)" ).append("\n"); 
		query.append("AND E.CNT_CD = SUBSTR(A.POD_CD,1,2)" ).append("\n"); 
		query.append("AND E.SYS_AREA_GRP_ID = C.DEST_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND E.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("AND F.USR_ID = A.DOC_USR_ID" ).append("\n"); 

	}
}