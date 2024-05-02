/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.12 류선우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 진행중인 RDN 번호를 조회한다.
	  * </pre>
	  */
	public RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAOBkgRevDrNoteVOExistRevDrNoteRSQL").append("\n"); 
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
		query.append("SELECT  MAX(RDN_NO) RDN_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  RDN_NO    ," ).append("\n"); 
		query.append("                RDN_STS_CD" ).append("\n"); 
		query.append("        FROM    BKG_REV_DR_NOTE A" ).append("\n"); 
		query.append("        WHERE   BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("        AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                            SELECT  'X'" ).append("\n"); 
		query.append("                            FROM  BKG_REV_DR_NOTE B" ).append("\n"); 
		query.append("                            WHERE B.RDN_NO    = A.RDN_NO" ).append("\n"); 
		query.append("                            AND   B.RVIS_SEQ  > A.RVIS_SEQ" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   RDN_STS_CD  NOT IN ( 'ST', 'CL' )" ).append("\n"); 

	}
}