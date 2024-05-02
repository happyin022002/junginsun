/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.05 
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

public class BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 나이지리아가 POL 일 때 (아웃바운드) EXS 값이 있는지 확인 (M&D의 Export&Import 팝업)
	  * 나이지리아가 POD 일 때 (인바운드) ENS 값이 있는지 확인 (M&D의 Export&Import 팝업)
	  * 
	  * effective date가 application date(rate) 기준 2016년 이후로 해당 로직 적용
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchNgExsEnsNoRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("decode((select 'Y'from bkg_vvd where bkg_no = @[bkg_no]and pol_cd like 'NG%' AND ROWNUM = 1), 'Y','Y','N') pol_cd," ).append("\n"); 
		query.append("decode((select 'Y'from bkg_vvd where bkg_no = @[bkg_no]and pod_cd like 'NG%' AND ROWNUM = 1), 'Y','Y','N') pod_cd," ).append("\n"); 
		query.append("nvl((" ).append("\n"); 
		query.append("     SELECT NG_EXS_ENS_NO" ).append("\n"); 
		query.append("     FROM BKG_VVD A, BKG_XPT_IMP_LIC B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     AND A.POL_CD LIKE 'NG%'" ).append("\n"); 
		query.append("     AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("     AND NG_EXS_ENS_NO is not null" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("),'') EXS," ).append("\n"); 
		query.append("nvl((" ).append("\n"); 
		query.append("     SELECT NG_EXS_ENS_NO" ).append("\n"); 
		query.append("     FROM BKG_VVD A, BKG_XPT_IMP_LIC B" ).append("\n"); 
		query.append("     WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("     AND A.POD_CD LIKE 'NG%'" ).append("\n"); 
		query.append("     AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("     AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("     AND NG_EXS_ENS_NO is not null" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 
		query.append("),'') ENS," ).append("\n"); 
		query.append("decode((select 'Y' from bkg_rate where bkg_no = @[bkg_no] and to_char(RT_APLY_DT,'yyyy') = '2016'),'Y','Y','N') eff_dt    " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}