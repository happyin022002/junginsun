/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOModifyCntrMtyBkgSplitUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.11
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.09.11 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOModifyCntrMtyBkgSplitUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Cod Update
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOModifyCntrMtyBkgSplitUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vl_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOModifyCntrMtyBkgSplitUSQL").append("\n"); 
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
		query.append("UPDATE EQR_VSL_EXE_PLN_QTY EPQ" ).append("\n"); 
		query.append("SET CNTR_QTY = ( SELECT COUNT(BC.CNTR_NO)" ).append("\n"); 
		query.append("                         FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                          ,   EQR_VSL_LODG_DCHG_EXE_PLN EP" ).append("\n"); 
		query.append("                        WHERE  EP.MTY_BKG_NO    = @[vl_bkg_no]" ).append("\n"); 
		query.append("                           AND EP.REPO_PLN_ID   = EPQ.REPO_PLN_ID" ).append("\n"); 
		query.append("                           AND EP.PLN_YRWK      = EPQ.PLN_YRWK" ).append("\n"); 
		query.append("                           AND EP.PLN_SEQ       = EPQ.PLN_SEQ" ).append("\n"); 
		query.append("                           AND EP.REF_ID        = EPQ.REF_ID" ).append("\n"); 
		query.append("                           AND EP.MTY_BKG_NO    = BC.BKG_NO" ).append("\n"); 
		query.append("                           AND EPQ.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        GROUP BY EPQ.REPO_PLN_ID, EPQ.PLN_YRWK, EPQ.PLN_SEQ, EPQ.REF_ID, EPQ.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("WHERE EXISTS  ( SELECT 'X'" ).append("\n"); 
		query.append("                         FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                          ,   EQR_VSL_LODG_DCHG_EXE_PLN EP" ).append("\n"); 
		query.append("                        WHERE  EP.MTY_BKG_NO    = @[vl_bkg_no]" ).append("\n"); 
		query.append("                           AND EP.REPO_PLN_ID   = EPQ.REPO_PLN_ID" ).append("\n"); 
		query.append("                           AND EP.PLN_YRWK      = EPQ.PLN_YRWK" ).append("\n"); 
		query.append("                           AND EP.PLN_SEQ       = EPQ.PLN_SEQ" ).append("\n"); 
		query.append("                           AND EP.REF_ID        = EPQ.REF_ID" ).append("\n"); 
		query.append("                           AND EP.MTY_BKG_NO    = BC.BKG_NO" ).append("\n"); 
		query.append("                           AND EPQ.CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                        GROUP BY EPQ.REPO_PLN_ID, EPQ.PLN_YRWK, EPQ.PLN_SEQ, EPQ.REF_ID, EPQ.CNTR_TPSZ_CD)" ).append("\n"); 

	}
}