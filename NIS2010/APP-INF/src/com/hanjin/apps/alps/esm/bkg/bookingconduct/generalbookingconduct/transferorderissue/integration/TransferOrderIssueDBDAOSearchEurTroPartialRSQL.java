/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroPartialRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.15 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroPartialRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tro confirm시 같은 cntr를 다른 bkg에서 confirm하는 지 확인한다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroPartialRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroPartialRSQL").append("\n"); 
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
		query.append("select bk2.bkg_no" ).append("\n"); 
		query.append("from bkg_eur_tro tro1" ).append("\n"); 
		query.append(", bkg_booking bk1" ).append("\n"); 
		query.append(", bkg_container cntr1" ).append("\n"); 
		query.append(", bkg_container cntr2" ).append("\n"); 
		query.append(", bkg_booking bk2" ).append("\n"); 
		query.append(", bkg_eur_tro tro2" ).append("\n"); 
		query.append("where tro1.bkg_no	      = @[bkg_no]" ).append("\n"); 
		query.append("and tro1.cntr_no       = @[cntr_no]" ).append("\n"); 
		query.append("and tro1.io_bnd_cd     = @[io_bnd_cd]" ).append("\n"); 
		query.append("and tro1.tro_seq       = @[tro_seq]" ).append("\n"); 
		query.append("and tro1.bkg_no        = bk1.bkg_no --해당 tro의 bkg의" ).append("\n"); 
		query.append("and tro1.bkg_no        = cntr1.bkg_no --cntr가" ).append("\n"); 
		query.append("and tro1.cntr_no       = cntr1.cntr_no --confirm하려는 tro에 assign되있는 데" ).append("\n"); 
		query.append("and cntr1.cntr_no      = cntr2.cntr_no --같은 cntr가" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_ID_NO , 0)   = nvl(CNTR2.CNMV_ID_NO , 0)" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_CYC_NO, 0)   = nvl(CNTR2.CNMV_CYC_NO, 0)" ).append("\n"); 
		query.append("AND nvl(CNTR1.CNMV_YR    , 'X') = nvl(CNTR2.CNMV_YR    , 'X')" ).append("\n"); 
		query.append("and bk1.bkg_no         <> bk2.bkg_no --다른 bkg의" ).append("\n"); 
		query.append("and tro2.bkg_no        = bk2.bkg_no --tro에" ).append("\n"); 
		query.append("and tro2.bkg_no		  = cntr2.bkg_no" ).append("\n"); 
		query.append("and tro2.cntr_no       = cntr2.cntr_no --assign되있고" ).append("\n"); 
		query.append("and bk2.bkg_sts_cd     <> 'X' --cancel bkg도 아니고" ).append("\n"); 
		query.append("and tro2.cfm_flg       = 'Y' --confirm 되어 있는 tro가" ).append("\n"); 
		query.append("and rownum			  = 1 --하나라도 잇으면 confirm 불가" ).append("\n"); 

	}
}