/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChk2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChk2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Creation Save 시 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChk2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChk2RSQL").append("\n"); 
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
		query.append("SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(retVal,':')),':')" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT X.retVal, ROWNUM ROW_ID FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT GL.CNTR_NO||'|'||GL.BKG_NO retVal" ).append("\n"); 
		query.append("FROM TES_GNTE_HDR GH, TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(GH.DMY_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND GH.GNTE_NO = GL.GNTE_NO" ).append("\n"); 
		query.append("and GH.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND GH.GNTE_CUST_CD = @[gnte_cust_cd]" ).append("\n"); 
		query.append("AND GH.GNTE_TP_CD = @[gnte_tp_cd] --2012.07.23 US Guarantee 중복 입력 check에 비용 Type 포함" ).append("\n"); 
		query.append("AND (GL.CNTR_NO, GL.BKG_NO) IN (" ).append("\n"); 
		query.append("#if (${cntr_bkg} != '')" ).append("\n"); 
		query.append("#foreach($cntr_bkg_num IN ${cntr_bkg})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT SUBSTR('$cntr_bkg_num',1,11) CNTR_NO, SUBSTR('$cntr_bkg_num',12,13) BKG_NO FROM DUAL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT SUBSTR('$cntr_bkg_num',1,11) CNTR_NO, SUBSTR('$cntr_bkg_num',12,13) BKG_NO FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND NVL(GH.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND GL.CRE_DT between TO_DATE(to_char(sysdate - 730, 'yyyymmdd'), 'YYYY-MM-DD')  and  TO_DATE(to_char(sysdate, 'yyyymmdd'),'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("START	WITH ROW_ID = 1" ).append("\n"); 
		query.append("CONNECT	BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 

	}
}