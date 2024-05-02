/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CARIssueTransferSlipManageDBDAOGetCancelledBkgNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CARIssueTransferSlipManageDBDAOGetCancelledBkgNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCancelledBkgNoList
	  * </pre>
	  */
	public CARIssueTransferSlipManageDBDAOGetCancelledBkgNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration ").append("\n"); 
		query.append("FileName : CARIssueTransferSlipManageDBDAOGetCancelledBkgNoListRSQL").append("\n"); 
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
		query.append("SELECT H.TML_SO_OFC_CTY_CD, H.TML_SO_SEQ, C.TML_SO_CNTR_LIST_SEQ, " ).append("\n"); 
		query.append("       C.CNTR_NO, B.BKG_NO, B.BL_NO, B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD   " ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST C, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = C.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND B.BKG_NO = (SELECT FM_BKG_NO FROM BKG_BOOKING K" ).append("\n"); 
		query.append("				WHERE K.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("				AND K.BKG_STS_CD = 'X')" ).append("\n"); 
		query.append("AND B.BKG_STS_CD IN ('F','W')" ).append("\n"); 

	}
}