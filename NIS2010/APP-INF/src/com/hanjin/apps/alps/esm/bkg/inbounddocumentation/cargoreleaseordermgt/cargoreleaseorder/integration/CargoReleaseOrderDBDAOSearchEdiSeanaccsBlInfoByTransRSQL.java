/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByTransRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByTransRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByTransRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByTransRSQL").append("\n"); 
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
		query.append("SELECT RPAD(DECODE(NVL(BKGM.BL_NO,' '),' ',' ','SMLM'||BKGM.BL_NO),35,' ')||CHR(13)||CHR(10)||" ).append("\n"); 
		query.append("       RPAD(NVL(NVL(BDO.JP_DO_ID, BDO.DO_NO),' '),10,' ')||CHR(13)||CHR(10)||                																																																																													" ).append("\n"); 
		query.append("       RPAD(NVL(NVL(DREF.CY_OP_CD,BJBL.CY_OPR_ID),' '),5,' ')||CHR(13)||CHR(10)||             																																																																													" ).append("\n"); 
		query.append("       DECODE( NVL(DREF.INFO_CGO_FLG,' '), 'N',' ','Y')||CHR(13)||CHR(10)																																																																													" ).append("\n"); 
		query.append("FROM ( SELECT BKG_NO" ).append("\n"); 
		query.append("             ,RLSE_SEQ" ).append("\n"); 
		query.append("       FROM BKG_JP_DO_IF" ).append("\n"); 
		query.append("       WHERE JP_DO_GRP_NO =  @[grp_no] -- 전송 대상 그룹핑으로 묶인 B/L" ).append("\n"); 
		query.append("       AND   JP_DO_SND_STS_CD = 'T'" ).append("\n"); 
		query.append(") SUB_MAIN" ).append("\n"); 
		query.append(", BKG_BOOKING     BKGM" ).append("\n"); 
		query.append(", BKG_DO          BDO" ).append("\n"); 
		query.append(", BKG_DO_REF      DREF" ).append("\n"); 
		query.append(", BKG_CSTMS_JP_BL BJBL" ).append("\n"); 
		query.append("WHERE SUB_MAIN.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("AND BDO.BKG_NO        = SUB_MAIN.BKG_NO" ).append("\n"); 
		query.append("AND BDO.RLSE_SEQ      = SUB_MAIN.RLSE_SEQ" ).append("\n"); 
		query.append("AND DREF.BKG_NO(+)    = BDO.BKG_NO  " ).append("\n"); 
		query.append("AND BJBL.BL_NO(+)     = BKGM.BL_NO" ).append("\n"); 

	}
}