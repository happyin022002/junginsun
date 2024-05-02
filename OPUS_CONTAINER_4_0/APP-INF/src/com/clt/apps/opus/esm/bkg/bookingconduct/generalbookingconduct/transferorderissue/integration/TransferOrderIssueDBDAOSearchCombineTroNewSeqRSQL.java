/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchCombineTroNewSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.30 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchCombineTroNewSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tro combine 이후의 seq를 미리 조회한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchCombineTroNewSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchCombineTroNewSeqRSQL").append("\n"); 
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
		query.append("select new_bkg_no, new_tro_seq, org_bkg_no, org_tro_Seq, tro_tp" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select new_bkg_no, rownum + max_tro_seq new_tro_seq, bkg_no org_bkg_no, tro_seq org_tro_Seq, 'GEN' tro_tp" ).append("\n"); 
		query.append("from bkg_tro tro," ).append("\n"); 
		query.append("(select nvl(max(tro.tro_seq), 0) max_tro_seq, bk.bkg_no new_bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_tro tro" ).append("\n"); 
		query.append("where bk.bkg_no = @[mst_bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = tro.bkg_no(+)" ).append("\n"); 
		query.append("group by bk.bkg_no) max_seq" ).append("\n"); 
		query.append("where bkg_no <> @[mst_bkg_no]" ).append("\n"); 
		query.append("#if (${combine_bkg_nos} != \"\")" ).append("\n"); 
		query.append("AND bkg_no IN (" ).append("\n"); 
		query.append("#foreach($combine_bkg_nosVal IN ${combine_bkg_nos})" ).append("\n"); 
		query.append("#if($velocityCount < $combine_bkg_nos.size()) '$combine_bkg_nosVal', #else '$combine_bkg_nosVal' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select new_bkg_no, rownum + max_tro_seq new_tro_seq, bkg_no org_bkg_no, tro_seq org_tro_Seq, 'EUR' tro_tp" ).append("\n"); 
		query.append("from bkg_eur_tro tro," ).append("\n"); 
		query.append("(select nvl(max(tro.tro_seq), 0) max_tro_seq, bk.bkg_no new_bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_eur_tro tro" ).append("\n"); 
		query.append("where bk.bkg_no = @[mst_bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = tro.bkg_no(+)" ).append("\n"); 
		query.append("group by bk.bkg_no) max_seq" ).append("\n"); 
		query.append("where bkg_no <> @[mst_bkg_no]" ).append("\n"); 
		query.append("#if (${combine_bkg_nos} != \"\")" ).append("\n"); 
		query.append("AND bkg_no IN (" ).append("\n"); 
		query.append("#foreach($combine_bkg_nosVal IN ${combine_bkg_nos})" ).append("\n"); 
		query.append("#if($velocityCount < $combine_bkg_nos.size()) '$combine_bkg_nosVal', #else '$combine_bkg_nosVal' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by org_bkg_no" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}