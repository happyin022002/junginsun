/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClaimMainDBDAOSearchBlGetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.22 정행룡
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONG HAENG RYONG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchBlGetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L No 정보 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchBlGetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_ref_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchBlGetRSQL").append("\n"); 
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
		query.append("SELECT A.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append(",A.RCV_TERM_CD ||A.DE_TERM_CD AS CRR_TERM_CD" ).append("\n"); 
		query.append(",B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS TRNK_REF_VVD_NO" ).append("\n"); 
		query.append(",C.VSL_ENG_NM AS VSL_ENG_NM" ).append("\n"); 
		query.append(",D.REP_CMDT_NM AS CGO_QLTY_DESC" ).append("\n"); 
		query.append(",A.SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append(",TO_CHAR(E.BL_OBRD_DT, 'YYYYMMDD') AS LODG_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append(",BKG_VVD B" ).append("\n"); 
		query.append(",MDM_VSL_CNTR C" ).append("\n"); 
		query.append(",MDM_REP_CMDT D" ).append("\n"); 
		query.append(",BKG_BL_DOC E" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.BL_NO = @[cgo_clm_ref_bl_no]" ).append("\n"); 
		query.append("AND B.VSL_PRE_PST_CD(+) = 'T'" ).append("\n"); 
		query.append("AND B.VSL_SEQ(+) = '0'" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.REP_CMDT_CD = D.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND A.BKG_NO = E.BKG_NO(+)" ).append("\n"); 

	}
}