/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChkRSQL.java
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

public class GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee Creation Grid에 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인함
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChkRSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchUSGuaranteeCntrDupChkRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("(CASE WHEN COUNT(*) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END ) cntr_dup_chk" ).append("\n"); 
		query.append("FROM TES_GNTE_HDR GH ," ).append("\n"); 
		query.append("TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(GH.DMY_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND GH.GNTE_NO = GL.GNTE_NO" ).append("\n"); 
		query.append("and GH.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND GH.GNTE_CUST_CD = @[gnte_cust_cd]" ).append("\n"); 
		query.append("AND GH.GNTE_TP_CD = @[gnte_tp_cd] --2012.07.23 US Guarantee 중복 입력 check에 비용 Type 포함" ).append("\n"); 
		query.append("AND GL.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND GL.cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("AND NVL(GH.delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("AND GL.cre_dt between TO_DATE(to_char(sysdate - 730, 'yyyymmdd'), 'YYYY-MM-DD')  and  TO_DATE(to_char(sysdate, 'yyyymmdd'),'YYYY-MM-DD') + 0.99999" ).append("\n"); 

	}
}