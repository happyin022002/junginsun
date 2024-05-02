/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByCancelRSQL.java
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

public class CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByCancelRSQL(){
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
		params.put("rlse_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiSeanaccsBlInfoByCancelRSQL").append("\n"); 
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
		query.append("       RPAD(' ',10)||CHR(13)||CHR(10)||                																																																																													" ).append("\n"); 
		query.append("       RPAD(' ',5)||CHR(13)||CHR(10)||             																																																																													" ).append("\n"); 
		query.append("       RPAD(' ',1)||CHR(13)||CHR(10)	" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BKGM " ).append("\n"); 
		query.append("     ,BKG_DO BDO" ).append("\n"); 
		query.append("     ,BKG_DO_REF DREF" ).append("\n"); 
		query.append("     ,BKG_CSTMS_JP_BL BJBL" ).append("\n"); 
		query.append("WHERE BDO.BKG_NO     = @[bkg_no] " ).append("\n"); 
		query.append("  AND BDO.RLSE_SEQ   = @[rlse_seq]" ).append("\n"); 
		query.append("  AND BKGM.BKG_NO    = BDO.BKG_NO " ).append("\n"); 
		query.append("  AND DREF.BKG_NO(+) = BDO.BKG_NO" ).append("\n"); 
		query.append("  AND BJBL.BL_NO(+)  = BKGM.BL_NO" ).append("\n"); 

	}
}